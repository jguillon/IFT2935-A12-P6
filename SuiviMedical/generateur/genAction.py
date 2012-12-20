# coding:utf-8

import random
import unicodedata
import datetime
from actionType import ActionType
from noassDoc import Doctors
from events import Events



def strip_accents(s):
   return ''.join((c for c in unicodedata.normalize('NFD', s) if unicodedata.category(c) != 'Mn'))

nb_action = len(ActionType)
nb_doc = len(Doctors)
nb_event = len(Events)


def genType():
	return u''.join((ActionType[int(random.random() * nb_action)]))

def genDates(noevent):
	dates = []
	dateD = datetime.date(Events[noevent][3],Events[noevent][2],Events[noevent][1])
	dateF = datetime.date(Events[noevent][6],Events[noevent][5],Events[noevent][4])
	d = int(random.random() * 28) + 1
	m = int(random.random() * 12) + 1
	y = 2005 + int(random.random() * 8)
	i = 0
	while(isInBetween(dateD.day,dateD.month,dateD.year,dateF.day,dateF.month,dateF.year, d, m, y)==False and i > 3):
		d = int(random.random() * 28) + 1
		m = int(random.random() * 12) + 1
		y = 2005 + int(random.random() * 8)
		i=i+1
	if(isInBetween(dateD.day,dateD.month,dateD.year,dateF.day,dateF.month,dateF.year, d, m, y)) :
		dateA = datetime.date(y,m,d)
	else :
		dateA = dateD
	return dateA
	#dates.append(('%02d' % d2) + '/' + ('%02d' % m2) + '/' + ('%d' % y2))
	
	return dates

def isInBetween(d1,m1,y1,d2,m2,y2,d3,m3,y3) :
	date13 = isBefore(d1,m1,y1,d3,m3,y3)
	date23 = isBefore(d2,m2,y2,d3,m3,y3)
	if(date13 == False and date23 == True) :
		return True
	else :
		return False
		
def isBefore(d1,m1,y1,d2,m2,y2): # retourne vrai si 1 est apres 2
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
	desc = genType()
	noevent = int(random.random()*nb_event)
	dateA = genDates(noevent)
	no = i+1
	values = u''.join(("  VALUES (", str(no),", ", \
		     		                 str(noevent + 1) , ", ", \
						             str(int(random.random()*nb_doc + 1)), ", ", \
				              	     "'", dateA.isoformat(), "', ", \
					                 "'", desc,"'); ")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print
	
if __name__ == '__main__':
	t = 'Action'
	n = 100
	for i in range(n):
		gen(t, i)
	#print "COMMIT;"
