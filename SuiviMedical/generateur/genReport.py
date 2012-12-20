# coding:utf-8

import random
import unicodedata
import datetime
from noassDoc import Doctors
from noassNur import Nurses
from events import Events
from reportDesc import word_1 
from reportDesc import adjWord_1 
from reportDesc import adjPatient 
import genAction

def strip_accents(s):
   return ''.join((c for c in unicodedata.normalize('NFD', s) if unicodedata.category(c) != 'Mn'))

nb_nur = len(Nurses)
nb_doc = len(Doctors)
nb_event = len(Events)
nb_ap = len(adjPatient)
nb_aw = len(adjWord_1)
nb_w = len(word_1)

def genDesc() :
	return u''.join(('Patient ', adjPatient[int(random.random()* nb_ap)],' ',word_1[int(random.random()* nb_w)],' ' , adjWord_1[int(random.random()* nb_aw)]))

def gen(t, i):
	desc = genDesc()
	noevent = int(random.random()*nb_event)
	dateA = genAction.genDates(noevent)
	no = i+1
	prob = int(random.random()*2)
	if( prob == 1) :
		values = u''.join(("  VALUES (", str(no),", ", \
		     		"", str(noevent + 1) ,", '" , str(Nurses[int(random.random()*nb_nur)]), "', ", \
					"'", dateA.isoformat(), "', ", \
					"'", desc,"', '');")).encode('utf-8').strip()
	else :
		values = u''.join(("  VALUES (", str(no),", ", \
		     		"", str(noevent + 1) ,", '" , str(Doctors[int(random.random()*nb_doc)]), "', ", \
					"'", dateA.isoformat(), "', ", \
					"'", desc,"', '');")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print
	
if __name__ == '__main__':
	t = 'Report'
	n = 100
	for i in range(n):
			gen(t, i)
	#print "COMMIT;"
