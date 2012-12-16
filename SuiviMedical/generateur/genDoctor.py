# coding:utf-8

import random
import unicodedata
from noass import NoAssurance
from specialty import Specialty


def strip_accents(s):
   return ''.join((c for c in unicodedata.normalize('NFD', s) if unicodedata.category(c) != 'Mn'))

nb_noass = len(NoAssurance)
nb_spec = len(Specialty)


def genSpecialty():
	return Specialty[int(random.random() * nb_spec)]

def genNoAssList(n):
	NoAssuranceDoctor = []
	for i in range(n):
		NoAssuranceDoctor.append(NoAssurance[i])
	return NoAssuranceDoctor

def gen(t, noAss, i):
	spec = genSpecialty()
	values = u''.join(("  VALUES (", str(i+1),", ", \
		     		"'", noAss,"', " , \
					"'" , spec , "');")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print
	
if __name__ == '__main__':
	t = 'Doctor'
	list = ''
	n = 10
	noasslist = genNoAssList(n)
	for i in range(n):
		gen(t, noasslist[i], i)
		if i!=(n-1) :
			list = u''.join((list,'u\'', noasslist[i], '\',\n\t\t\t'))
		else :
			list = u''.join((list,'u\'', noasslist[i], '\''))
	file = open('noassDoc.py','w')
	fileNoAss = u''.join(('#coding:utf-8 \n', 'Doctors = [',list, ']'))
	file.write(fileNoAss.encode('utf-8').strip())
	#print "COMMIT;"
