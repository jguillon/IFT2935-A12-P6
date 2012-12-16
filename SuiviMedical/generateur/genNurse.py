# coding:utf-8

import random
import unicodedata
from noass import NoAssurance
from noassDoc import Doctors


def strip_accents(s):
   return ''.join((c for c in unicodedata.normalize('NFD', s) if unicodedata.category(c) != 'Mn'))

nb_noass = len(NoAssurance)


def removeDoctorsFromList() :
	Candidats = []
	for i in range(len(Doctors)):
		for j in range(len(NoAssurance)):
			if(Doctors[i] != NoAssurance[j]):
				Candidats.append(NoAssurance[j])
	return Candidats

def genNoAssList(n):
	NoAssuranceNurse = []
	NoAssuranceCandidats = removeDoctorsFromList()
	for i  in range(n):
		NoAssuranceNurse.append(NoAssuranceCandidats[int(random.random() * nb_noass)])
	return NoAssuranceNurse


def gen(t, noAss, i):
	values = u''.join(("  VALUES (", str(i+1),", ", \
		     		"'", noAss,"');")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print
	
if __name__ == '__main__':
	t = 'Nurse'
	list = ''
	dependanceFile = ''
	n = 10
	noasslist = genNoAssList(n)
	for i in range(n):
		gen(t, noasslist[i], i)
		if i!=(n-1) :
			list = u''.join((list,'u\'', noasslist[i], '\',\n\t\t\t'))
		else :
			list = u''.join((list,'u\'', noasslist[i], '\''))
	
	file = open('noassNur.py','w')
	fileNoAss = u''.join(('#coding:utf-8 \n', 'Nurses = [',list, ']'))
	file.write(fileNoAss.encode('utf-8').strip())
	#print "COMMIT;"
