# coding:utf-8

import random
import unicodedata
from noass import NoAssurance
from noassPat import Patients



nb_noass = len(NoAssurance)

typeDependant = ['Mother', 'Father', 'Wife', 'Husband', 'Son', 'Daughter', 'Cousin', 'Brother', 'Sister', \
'Uncle', 'Aunt', 'Grand-Mother','Grand-father','Partner', 'Coworker', 'Friend', 'Other']

def genNbre() :
	prob = random.random()
	return int(prob*len(Patients))

def genDependance():
	return typeDependant[int(random.random() * len(typeDependant))]

def genNoAssList(n):
	NoAssuranceDependant = []
	for i  in range(n):
		NoAssuranceDependant.append(NoAssurance[int(random.random() * nb_noass)])
	return NoAssuranceDependant

def genNoAssPatient():
	return Patients[int(random.random() * len(Patients))]

def gen(t, noAss, i):
	values = u''.join(("  VALUES (", str(i+1),", ", \
		     		"'", noAss,"');")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print
	#file = open('dependance.sql', 'w')
	dependanceFile = u''.join(('INSERT INTO ', t, '\n VALUES (\'',noAss, '\',\'', genNoAssPatient(), '\',\'', genDependance(), '\';)\n')).encode('utf-8').strip()
	#file.write(dependanceFile)
	
if __name__ == '__main__':
	t = 'Dependant'
	list = ''
	dependanceFile = ''
	n = genNbre()
	noasslist = genNoAssList(n)
	for i in range(n):
		gen(t, noasslist[i], i)
		dependanceFile = u''.join((dependanceFile,'\nINSERT INTO ', 'Dependance', '\n VALUES (\'',noasslist[i], '\',\'', genNoAssPatient(), '\',\'', genDependance(), '\');')).encode('utf-8').strip()
		if i!=(n-1) :
			list = u''.join((list,'u\'', noasslist[i], '\',\n\t\t\t'))
		else :
			list = u''.join((list,'u\'', noasslist[i], '\''))
	
	file = open('base/dependance.sql', 'w')
	dependanceFile = u''.join((dependanceFile, "\n COMMIT;"))
	file.write(dependanceFile)		
	
	file = open('noassDep.py','w')
	fileNoAss = u''.join(('#coding:utf-8 \n', 'Dependants = [',list, ']'))
	file.write(fileNoAss.encode('utf-8').strip())
	#print "COMMIT;"
