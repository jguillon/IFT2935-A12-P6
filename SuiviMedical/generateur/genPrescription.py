#coding:utf-8

import random
import unicodedata
import datetime
from medicament import Medicaments 
from medicament import Unites 
from medicament import Frequences
from medicament import UnitesTemps 
from noassDoc import Doctors
from events import Events
import genAction

nb_med = len(Medicaments)
nb_un = len(Unites)
nb_freq = len(Frequences)
nb_unT = len(UnitesTemps)
nb_doc = len(Doctors)
nb_event = len(Events)

def nbPresc() :
	return 100

def genDate(earliest):
        d = int(random.random() * 28) + 1
        m = int(random.random() * 12) + 1
        y = earliest + int(random.random() * (2012 - earliest))

        return ('%d' % y)+ '/' + ('%02d' % m) + '/' +  ('%02d' % d)

def genMed():
	med = ["","","",""]
	med[0] = Medicaments[int(random.random()* nb_med)]
	med[1] = u''.join((str(int(random.random()*100 + 1))," ",Unites[int(random.random()* nb_un)]))
	med[2] = Frequences[int(random.random()* nb_freq)]
	med[3] = u''.join((str(int(random.random()*10 + 1))," ",UnitesTemps[int(random.random()*nb_unT)]))
	return med

def gen(t, i):
	med = genMed()
	noevent = int(random.random()*nb_event)
	dateA = genAction.genDates(noevent)
	no = i+1
	values = u''.join(("  VALUES (", str(no),", ", \
		     		"", str(noevent + 1) ,", " , str(int(random.random()*nb_doc + 1))\
					, ", '", genDate(2005) , "'"\
					, ", '", med[0] , "' ,'", med[1], "' , '", med[2], "' , '" \
					, med[3],"');")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print
	
if __name__ == '__main__':
	t = 'Prescription'
	n = nbPresc()
	for i in range(n):
		gen(t, i)
	#print "COMMIT;"
