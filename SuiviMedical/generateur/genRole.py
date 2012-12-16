# coding:utf-8

import random
import unicodedata
from noassDoc import Doctors
from noassPat import Patients
from noassDep import Dependants
from noassNur import Nurses


nb_doc = len(Doctors)
nb_pat = len(Patients)
nb_dep = len(Dependants)
nb_nur = len(Nurses)

def gen(t, noAss, role):
	values = u''.join(("  VALUES ('" \
		     		, noAss,"','",role,"');")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print

	
if __name__ == '__main__':
	t = 'Role'

	for i in range(nb_doc):
		gen(t, Doctors[i], 'Doctor')
	for i in range(nb_pat):
		gen(t,Patients[i], 'Patient')
	for i in range(nb_dep):
		gen(t,Dependants[i], 'Dependant')
	for i in range(nb_nur):
		gen(t,Nurses[i], 'Nurse')
	#print "COMMIT;"
