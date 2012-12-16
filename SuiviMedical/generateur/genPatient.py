# coding:utf-8

import random
import unicodedata
from noass import NoAssurance


def strip_accents(s):
   return ''.join((c for c in unicodedata.normalize('NFD', s) if unicodedata.category(c) != 'Mn'))

nb_noass = len(NoAssurance)

typePatient = ['Traitement', 'Convalescence', 'Surveillance']

def genPatient():
	return typePatient[int(random.random() * 3)]

def genNoAssList(n):
	NoAssurancePatient = []
	for i  in range(n):
		NoAssurancePatient.append(NoAssurance[int(random.random() * nb_noass)])
	return NoAssurancePatient

def gen(t, noAss, i):
	values = u''.join(("  VALUES (", str(i+1),", ", \
		     		"'", noAss,"', " , \
					"'" , genPatient() , "');")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print
	
if __name__ == '__main__':
	t = 'Patient'
	list = ''
	dossierFile = ''
	n = 10
	noasslist = genNoAssList(n)
	for i in range(n):
		gen(t, noasslist[i], i)
		dossierFile = u''.join((dossierFile,'\nINSERT INTO ', 'Dossier', '\n VALUES (', str(i+1),',\'',noasslist[i],'\');\n')).encode('utf-8').strip()
		if i!=(n-1) :
			list = u''.join((list,'u\'', noasslist[i], '\',\n\t\t\t'))
		else :
			list = u''.join((list,'u\'', noasslist[i], '\''))
		
	file = open('base/dossier.sql', 'w')
	#dossierFile = u''.join((dossierFile, "\n COMMIT;"))
	file.write(dossierFile)	
	
	file = open('noassPat.py','w')
	fileNoAss = u''.join(('#coding:utf-8 \n', 'Patients = [',list, ']'))
	file.write(fileNoAss.encode('utf-8').strip())
	#print "COMMIT;"
