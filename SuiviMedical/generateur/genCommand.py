#coding:utf-8

import unicodedata
import random
import genPrescription

def genCommandDate(earliest):
        d = int(random.random() * 28) + 1
        m = int(random.random() * 12) + 1
        y = earliest + int(random.random() * 7)

        return "'" + ('%d' % y) + '-' + ('%02d' % m) + '-' +  ('%02d' % d) + "'"


def gen(t, i):
	no = i+1
	values = u''.join(("  VALUES (", str(int(random.random()*genPrescription.nbPresc())),", ", \
		     		genCommandDate(2005), ", ", str(int(random.random()*999 + 1)), ");")).encode('utf-8').strip()
	print "INSERT INTO " + t
	print values
	print
	
if __name__ == '__main__':
	t = 'Command'
	n = 10
	for i in range(n):
			gen(t, i)
	#print "COMMIT;"
