# coding:utf-8

import random
import unicodedata
import datetime
from events import Events
import statusCreator
import genAction

nb_event = len(Events)

# def genTime() :
# 	time = [0,0]
# 	time[0] = int(random.random()*24)
# 	time[1] = int(random.random()*50 + 10)
# 	return time

def gen(t, i):
	status = statusCreator.genStatus()
	statusType = status[0]
	statusValue = status[1]
	noevent = int(random.random()*nb_event)
	dateA = genAction.genDates(noevent)
	statusTimestamp = dateA.isoformat()
	statusTimestamp += " " + str(int(random.random()*24)) + ":" + str(int(random.random()*50 + 10))
	
	no = i+1
	values = u''.join(["  VALUES (", \
					                str(no), ", ", \
		     		                str(noevent + 1) , ", ", \
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
