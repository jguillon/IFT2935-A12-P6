# coding:utf-8

import random
import unicodedata
import datetime
from diagnosis import Diagnosis
from noassDoc import Doctors
from events import Events
import genAction


nb_dia = len(Diagnosis)
nb_doc = len(Doctors)
nb_event = len(Events)

def genDiagnosis():
	return u''.join((Diagnosis[int(random.random() * nb_dia)]))


def gen(t, i):
	desc = genDiagnosis()
	noevent = int(random.random()*nb_event)
	dateA = genAction.genDates(noevent)
	no = i+1
	values = u''.join(("  VALUES (", str(no),", ", \
		     		"", str(noevent + 1) ,", " , str(int(random.random()*nb_doc + 1)), ", ", \
					"'", dateA.isoformat(), "', ", \
					"'", desc,"');")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print
	
if __name__ == '__main__':
	t = 'Diagnosis'
	n = 100
	for i in range(n):
		gen(t, i)
	#print "COMMIT;"
