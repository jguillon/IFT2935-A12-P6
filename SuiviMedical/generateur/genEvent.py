# coding:utf-8

import random
import unicodedata
import datetime
from eventDesc import EventDesc
from eventDesc import Severite
from noassPat import Patients


def strip_accents(s):
   return ''.join((c for c in unicodedata.normalize('NFD', s) if unicodedata.category(c) != 'Mn'))

nb_eventDesc = len(EventDesc)
nb_sev = len(Severite)
nb_dossiers = len(Patients)


def genDesc():
	return u''.join((EventDesc[int(random.random() * nb_eventDesc)], ' ' , Severite[int(random.random() * nb_sev)]))

def genDates():
	dates = []
	
	d = int(random.random() * 28) + 1
	m = int(random.random() * 12) + 1
	y = 2005 + int(random.random() * 8)
	date1 = datetime.date(y,m,d)
	dates.append(date1)

	d2 = int(random.random() * 28) + 1
	m2 = int(random.random() * 12) + 1
	y2 = 2005 + int(random.random() * 8)

	while(isBefore(d,m,y,d2,m2,y2)):
		d2 = int(random.random() * 28) + 1
		m2 = int(random.random() * 12) + 1
		y2 = 2005 + int(random.random() * 8)
	dates.append(datetime.date(y2,m2,d2))
	
	return dates
	
def isBefore(d1,m1,y1,d2,m2,y2):
	if y1 > y2 :
		return True
	if y1 < y2 :
		return False
	if m1 > m2 :
		return True
	if m1 < m2 :
		return False
	if d1 > d2 :
		return True
	if d1 < d2 :
		return False
	return False #on veut pouvoir avoir aussi le meme jour

def gen(t, i):
	desc = genDesc()
	dates = genDates()
	no = i+1
	dateD = dates[0]
	dateF = dates[1]
	prob = int(random.random()*2);
	if( prob == 0) :
		values = u''.join(("  VALUES (", str(no),", ", \
		     	          	         str(int(random.random()*nb_dossiers) + 1) , ", ", \
					                 "'", dateD.isoformat(), "', ", \
					                 "'", dateF.isoformat(), "', ", \
					                 "'", desc,"');")).encode('utf-8').strip()
	else :
		values = u''.join(("  VALUES (", str(no),", ", \
		     	          	         str(int(random.random()*nb_dossiers) + 1) , ", ", \
					                 "'", dateD.isoformat(), "', ", \
					                 "'", "NULL", "', ", \
					                 "'", desc,"');")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print
	return "[ " + str(no) +  "," + str(dateD.day) + "," + str(dateD.month) + "," + str(dateD.year) + "," + str(dateF.day) + "," + str(dateF.month) + ","\
			+ str(dateF.year) + "]"
	
if __name__ == '__main__':
	t = 'Event'
	list = ''
	events = ""
	n = 100
	for i in range(n):
		if(i!=(n-1)) :
			events = u''.join((events, gen(t, i), ",\n\t\t\t"))
		else :
			events = u''.join((events, gen(t, i)))
	file = open('events.py','w')
	events = u''.join(("#coding:utf-8\n","Events = [", events, "]"))
	file.write(events)
	#print "COMMIT;"
