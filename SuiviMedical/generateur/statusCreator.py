#coding:utf-8

import random
import unicodedata
from status import Status 

nb_status = len(Status)

def genStatus():
	typeValue = ['',0]
	for i in range(300) :
		prob = int(random.random()*20)
		type = Status[int(random.random()*nb_status)]
		if( type == 'Temperature' ):
			temperature = 0
			if(prob == 15 or prob == 16):
				temperature = random.random() + 37.5
			elif(prob == 17):
				temperature = random.random()*3 + 38.5
			elif(prob == 18 or prob == 19):
				temperature = random.random() + 35.5
			elif(prob == 20):
				temperature = random.random() + 34.5
			else:
				temperature = random.random() + 36.5
			typeValue[0] = "Temperature"
			typeValue[1] = temperature
			return typeValue #"Temperature = " + str("{0:.2f}".format(temperature)) + ' C'
		elif( type == 'Saturation O2' ) :
			saturation = 0
			if(prob == 15 or prob == 16):
				saturation = int(random.random()) + 96
			elif(prob == 17 or prob == 18):
				saturation = int(random.random()*2) + 94
			elif(prob == 19):
				saturation = int(random.random()*5) + 90
			elif(prob == 20):
				saturation = 100
			else:
				saturation = int(random.random()*3) + 97
			typeValue[0] = "Saturation O2"
			typeValue[1] = saturation
			return typeValue #"Saturation O2 = " + str(saturation) + '%'
		elif( type == 'Frequence respiratoire' ) :
			freq = 0
			if(prob == 15 or prob == 16):
				freq = int(random.random()*10) + 30
			elif(prob == 17 or prob == 18):
				freq = int(random.random()*10) + 20
			elif(prob == 19):
				freq = int(random.random()*30) + 40
			elif(prob == 20):
				freq = int(random.random()*7) + 6
			else:
				freq = int(random.random()*9) + 12
			typeValue[0] = "Frequence respiratoire"
			typeValue[1] = freq
			return typeValue #"Frequence respiratoire = " + str(freq) + ' cyles par minutes'
		elif( type == 'Frequence cardiaque' ) :
			freq = 0
			if(prob == 15 or prob == 16):
				freq = int(random.random()*10) + 50
			elif(prob == 17 or prob == 18):
				freq = int(random.random()*20) + 90
			elif(prob == 19):
				freq = int(random.random()*30) + 110
			elif(prob == 20):
				freq = int(random.random()*20) + 30
			else:
				freq = int(random.random()*30) + 60
			typeValue[0] = "Frequence cardiaque"
			typeValue[1] = freq
			return typeValue #"Frequence cardiaque = " + str(freq) + ' pulsations par minutes'
		elif( type == 'Pression systolique' ) :
			pression = 0
			if(prob == 15 or prob == 16):
				pression = int(random.random()*20) + 140
			elif(prob == 17 or prob == 18):
				pression = int(random.random()*20) + 160
			elif(prob == 19):
				pression = int(random.random()*10) + 180
			elif(prob == 20):
				pression = int(random.random()*20) + 100
			else:
				pression = int(random.random()*20) + 120
			typeValue[0] = "Pression systolique"
			typeValue[1] = pression
			return typeValue #"Pression systolique = " + str(pression) + ' mm de mercure'
		elif( type == 'Pression diastolique' ) :
			pression = 0
			if(prob == 15 or prob == 16):
				pression = int(random.random()*10) + 90
			elif(prob == 17 or prob == 18):
				pression = int(random.random()*10) + 100
			elif(prob == 19):
				pression = int(random.random()*10) + 110
			elif(prob == 20):
				pression = int(random.random()*10) + 80
			else:
				pression = int(random.random()*10) + 90
			typeValue[0] = "Pression diastolique"
			typeValue[1] = pression
			return typeValue #"Pression diastolique = " + str(pression) + ' mm de mercure'
		elif( type == 'Taux de glucose' ) :
			glucose = 0
			if(prob == 15 or prob == 16):
				glucose = random.random()*0.2 + 1.24
			elif(prob == 17 or prob == 18):
				glucose = random.random()*0.24 + 1
			else:
				glucose = random.random()*0.47 + 0.63
			typeValue[0] = "Taux de glucose"
			typeValue[1] = glucose
			return typeValue #"Taux de glucose = " + str("{0:.2f}".format(glucose)) + ' g/L'
		elif (type == 'IMC') :
			imc = 0
			if(prob == 15 or prob == 16):
				imc = random.random()*5 + 25
			elif(prob == 17 or prob == 18):
				imc = random.random()*2.5 + 16
			elif(prob == 19):
				imc = random.random()*2 + 16
			elif(prob == 20):
				imc = random.random()*10 + 30
			else:
				imc = random.random()*6.5 + 18.5
			typeValue[0] = "IMC"
			typeValue[1] = imc
			return typeValue #"IMC = " + str("{0:.2f}".format(imc))
	return typeValue