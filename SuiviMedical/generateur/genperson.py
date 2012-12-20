# coding:utf-8

import random
from familles import noms
from prenoms import prenoms
from villes import villes
from provinces import provinces
from pays import pays
import unicodedata

def strip_accents(s):
   return ''.join((c for c in unicodedata.normalize('NFD', s) if unicodedata.category(c) != 'Mn'))

nb_noms = len(noms)
nb_prenoms = len(prenoms)
midnames = prenoms
nb_midnames = len(midnames)
nb_villes = len(villes)
nb_provinces = len(provinces)
nb_pays = len(pays)

sexes = ['M', 'F']
digits = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
alpha = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ'



def genNAM():
	return ''.join([random.choice(digits) for x in range(8)])


def genFname():
	return prenoms[int(random.random() * nb_prenoms)]

def genMname():
	if random.random() > .65:
		return midnames[int(random.random() * nb_midnames)]
	else:
		return ''

def genLname():
	return noms[int(random.random() * nb_noms)][1]

def genBdate():
	d = int(random.random() * 28) + 1
	m = int(random.random() * 12) + 1
	y = 1900 + int(random.random() * 112)

	return ('%d' % y)+ '/' + ('%02d' % m) + '/' +  ('%02d' % d)

def genSex():
	return random.choice(sexes)

def genNostreet():
	return str(int(random.random() * 12000))

def genStreet():
	return 'rue ' + genLname()

def genAppt():
	if (random.random() > .72):
		return str(int(random.random() * 300))
	else:
		return ''

def genCity():
	return villes[int(random.random() * nb_villes)]

def genProvince():
	return provinces[int(random.random() * nb_provinces)]

def genPC():
	return random.choice(alpha) + random.choice(digits) + \
           random.choice(alpha) + random.choice(digits) + \
		   random.choice(alpha) + random.choice(digits)

def genCountry():
	return pays[int(random.random() * nb_pays)]

def genNoTel():
	return ''.join([random.choice(digits) for x in range(10)])

def gen(t, list, virgule):
	lname = genLname()
	fname = genFname()
	noass = u''.join(('\'',strip_accents(unicode(lname[:3].upper())), \
		                  strip_accents(unicode(fname[0].upper())), genNAM(), '\''))
	if virgule:
		noasslist = u''.join((list,'u',noass, ',\n\t\t\t\t'))
	else:
		noasslist = u''.join((list,'u',noass))
	values = u''.join(("  VALUES (", noass,", ", \
		     		"'", fname,"', " , \
					"'" , genMname() , "', " , \
					"'" , lname , "', " , \
					"'" , genBdate(), "', " ,\
					"'" , genSex() , "', " , \
					"'" , genNostreet() , "', " , \
					"'" , genStreet() , "', " , \
					"'" , genAppt() , "', " , \
					"'" , genCity() , "', " , \
					"'" , genProvince() , "', " , \
					"'" , genPC() , "', " , \
					"'" , genCountry() , "', " , \
					"'" , genNoTel() , "', " , \
					"'" , strip_accents(fname) , "." , \
					      strip_accents(lname) , \
						  "@mymail.com');")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print
	return noasslist
	
if __name__ == '__main__':
	t = 'Person'
	list = ''
	n = 100
	for i in range(n):
		if (i!=(n-1)):
			list = u''.join((gen(t, list, True)) )
		else :
			list = u''.join((gen(t, list, False)) )
	file = open('noass.py','w')
	fileNoAss = u''.join(('#coding:utf-8 \n', 'NoAssurance = [',list, ']'))
	file.write(fileNoAss.encode('utf-8').strip())	
	#print "COMMIT;"
