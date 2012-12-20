# coding:utf-8

import random
import unicodedata
import datetime
from noassPat import Patients
import statusCreator
import genAction

nb_dossiers = len(Patients)

def genDate() :
 	d = int(random.random() * 28) + 1
	m = int(random.random() * 12) + 1
	y = 2005 + int(random.random() * 8)
	date1 = datetime.date(y,m,d)
 	return date1

def gen(t, i):
	status = statusCreator.genStatus()
	statusType = status[0]
	statusValue = status[1]
	nodossier = int(random.random()*nb_dossiers)
	dateA = genDate();
	statusTimestamp = dateA.isoformat()
	statusTimestamp += " " + str(int(random.random()*24)) + ":" + str(int(random.random()*50 + 10))
	
	no = i+1
	values = u''.join(["  VALUES (", \
					                str(no), ", ", \
		     		                str(nodossier + 1) , ", ", \
						            "'", statusTimestamp, "'", ", ", \
						            "'", str(statusType),"',", \
						            str(statusValue), ");"])

	print "INSERT INTO " + t
	print values
	print
	return ""
	
if __name__ == '__main__':
	t = 'Statut'
	n = 100
	for i in range(n):
		gen(t, i)
	#print "COMMIT;"
