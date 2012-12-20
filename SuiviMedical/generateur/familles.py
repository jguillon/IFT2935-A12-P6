# coding:utf-8

noms     = [[1,	u'Tremblay',	1.076],
            [2,	u'Gagnon',	0.790],
			[3,	u'Roy',	0.753],
			[4,	u'Côté',	0.692],
			[5,	u'Bouchard',	0.530],
			[6,	u'Gauthier',	0.522],
			[7,	u'Morin',	0.498],
			[8,	u'Lavoie',	0.459],
			[9,	u'Fortin',	0.449],
			[10,	u'Gagné',	0.448],
			[11,	u'Ouellet',	0.447],
			[12,	u'Pelletier',	0.435],
			[13,	u'Bélanger',	0.429],
			[14,	u'Lévesque',	0.412],
			[15,	u'Bergeron',	0.399],
			[16,	u'Leblanc',	0.367],
			[17,	u'Paquette',	0.361],
			[18,	u'Girard',	0.356],
			[19,	u'Simard',	0.354],
			[20,	u'Boucher',	0.341],
			[21,	u'Caron',	0.321],
			[22,	u'Beaulieu',	0.300],
			[23,	u'Cloutier',	0.297],
			[24,	u'Dubé',	0.296],
			[25,	u'Poirier',	0.295],
			[26,	u'Fournier',	0.293],
			[27,	u'Lapointe',	0.290],
			[28,	u'Leclerc',	0.285],
			[29,	u'Lefebvre',	0.279],
			[30,	u'Poulin',	0.268],
			[31,	u'Thibault',	0.268],
			[32,	u'St-Pierre',	0.264],
			[33,	u'Nadeau',	0.258],
			[34,	u'Martin',	0.257],
			[35,	u'Landry',	0.254],
			[36,	u'Martel',	0.250],
			[37,	u'Bédard',	0.250],
			[38,	u'Grenier',	0.249],
			[39,	u'Lessard',	0.238],
			[40,	u'Bernier',	0.233],
			[41,	u'Richard',	0.228],
			[42,	u'Michaud',	0.225],
			[43,	u'Hébert',	0.224],
			[44,	u'Desjardins',	0.223],
			[45,	u'Couture',	0.220],
			[46,	u'Turcotte',	0.220],
			[47,	u'Lachance',	0.218],
			[48,	u'Parent',	0.216],
			[49,	u'Blais',	0.214],
			[50,	u'Gosselin',	0.212],
			[51,	u'Savard',	0.211],
			[52,	u'Proulx',	0.209],
			[53,	u'Beaudoin',	0.207],
			[54,	u'Demers',	0.203],
			[55,	u'Perreault',	0.203],
			[56,	u'Boudreau',	0.199],
			[57,	u'Lemieux',	0.195],
			[58,	u'Cyr',	0.193],
			[59,	u'Perron',	0.193],
			[60,	u'Dufour',	0.191],
			[61,	u'Dion',	0.189],
			[62,	u'Mercier',	0.189],
			[63,	u'Bolduc',	0.187],
			[64,	u'Bérubé',	0.186],
			[65,	u'Boisvert',	0.186],
			[66,	u'Langlois',	0.184],
			[67,	u'Ménard',	0.181],
			[68,	u'Therrien',	0.178],
			[69,	u'Plante',	0.177],
			[70,	u'Bilodeau',	0.177],
			[71,	u'Blanchette',	0.176],
			[72,	u'Dubois',	0.176],
			[73,	u'Champagne',	0.174],
			[74,	u'Paradis',	0.171],
			[75,	u'Fortier',	0.170],
			[76,	u'Arsenault',	0.170],
			[77,	u'Dupuis',	0.169],
			[78,	u'Gaudreault',	0.169],
			[79,	u'Hamel',	0.169],
			[80,	u'Houle',	0.169],
			[81,	u'Villeneuve',	0.165],
			[82,	u'Rousseau',	0.164],
			[83,	u'Gravel',	0.163],
			[84,	u'Thériault',	0.163],
			[85,	u'Lemay',	0.160],
			[86,	u'Robert',	0.158],
			[87,	u'Allard',	0.157],
			[88,	u'Deschênes',	0.157],
			[89,	u'Giroux',	0.155],
			[90,	u'Guay',	0.155],
			[91,	u'Leduc',	0.155],
			[92,	u'Boivin',	0.153],
			[93,	u'Charbonneau',	0.153],
			[94,	u'Lambert',	0.152],
			[95,	u'Raymond',	0.151],
			[96,	u'Vachon',	0.150],
			[97,	u'Gilbert',	0.148],
			[98,	u'Audet',	0.147],
			[99,	u'Jean',	0.147],
			[100,	u'Larouche',	0.146],
			[101,	u'Legault',	0.144],
			[102,	u'Trudel',	0.142],
			[103,	u'Fontaine',	0.141],
			[104,	u'Picard',	0.140],
			[105,	u'Labelle',	0.140],
			[106,	u'Lacroix',	0.138],
			[107,	u'Jacques',	0.137],
			[108,	u'Moreau',	0.137],
			[109,	u'Carrier',	0.137],
			[110,	u'Bernard',	0.134],
			[111,	u'Desrosiers',	0.133],
			[112,	u'Goulet',	0.133],
			[113,	u'Renaud',	0.132],
			[114,	u'Dionne',	0.131],
			[115,	u'Lapierre',	0.130],
			[116,	u'Vaillancourt',	0.130],
			[117,	u'Fillion',	0.129],
			[118,	u'Lalonde',	0.129],
			[119,	u'Tessier',	0.129],
			[120,	u'Bertrand',	0.128],
			[121,	u'Tardif',	0.127],
			[122,	u'Lepage',	0.127],
			[123,	u'Gingras',	0.126],
			[124,	u'Benoît',	0.125],
			[125,	u'Rioux',	0.124],
			[126,	u'Giguère',	0.123],
			[127,	u'Drouin',	0.122],
			[128,	u'Harvey',	0.122],
			[129,	u'Lauzon',	0.122],
			[130,	u'Nguyen',	0.122],
			[131,	u'Gendron',	0.122],
			[132,	u'Boutin',	0.122],
			[133,	u'Laflamme',	0.121],
			[134,	u'Vallée',	0.120],
			[135,	u'Dumont',	0.120],
			[136,	u'Breton',	0.119],
			[137,	u'Paré',	0.119],
			[138,	u'Paquin',	0.119],
			[139,	u'Robitaille',	0.119],
			[140,	u'Gélinas',	0.117],
			[141,	u'Duchesne',	0.117],
			[142,	u'Lussier',	0.115],
			[143,	u'Séguin',	0.115],
			[144,	u'Veilleux',	0.114],
			[145,	u'Potvin',	0.114],
			[146,	u'Gervais',	0.114],
			[147,	u'Pépin',	0.113],
			[148,	u'Laroche',	0.113],
			[149,	u'Morissette',	0.112],
			[150,	u'Charron',	0.111],
			[151,	u'Lavallée',	0.111],
			[152,	u'Laplante',	0.111],
			[153,	u'Chabot',	0.110],
			[154,	u'Brunet',	0.108],
			[155,	u'Vézina',	0.108],
			[156,	u'Desrochers',	0.108],
			[157,	u'Labrecque',	0.107],
			[158,	u'Coulombe',	0.107],
			[159,	u'Tanguay',	0.106],
			[160,	u'Chouinard',	0.105],
			[161,	u'Noël',	0.105],
			[162,	u'Pouliot',	0.104],
			[163,	u'Lacasse',	0.104],
			[164,	u'Daigle',	0.103],
			[165,	u'Marcoux',	0.103],
			[166,	u'Lamontagne',	0.102],
			[167,	u'Turgeon',	0.102],
			[168,	u'Larocque',	0.101],
			[169,	u'Roberge',	0.101],
			[170,	u'Auger',	0.100],
			[171,	u'Massé',	0.100],
			[172,	u'Pilon',	0.100],
			[173,	u'Racine',	0.100],
			[174,	u'Dallaire',	0.099],
			[175,	u'Émond',	0.099],
			[176,	u'Grégoire',	0.099],
			[177,	u'Beauregard',	0.099],
			[178,	u'Smith',	0.098],
			[179,	u'Denis',	0.098],
			[180,	u'Lebel',	0.098],
			[181,	u'Blouin',	0.097],
			[182,	u'Martineau',	0.097],
			[183,	u'Labbé',	0.097],
			[184,	u'Beauchamp',	0.096],
			[185,	u'St-Onge',	0.096],
			[186,	u'Charette',	0.095],
			[187,	u'Dupont',	0.095],
			[188,	u'Létourneau',	0.094],
			[189,	u'Rodrigue',	0.093],
			[190,	u'Cormier',	0.093],
			[191,	u'Rivard',	0.093],
			[192,	u'Mathieu',	0.093],
			[193,	u'Asselin',	0.093],
			[194,	u'St-Jean',	0.092],
			[195,	u'Plourde',	0.092],
			[196,	u'Thibodeau',	0.091],
			[197,	u'Bélisle',	0.091],
			[198,	u'St-Laurent',	0.091],
			[199,	u'Godin',	0.091],
			[200,	u'Desbiens',	0.090],
			[201,	u'Lavigne',	0.090],
			[202,	u'Doucet',	0.090],
			[203,	u'Labonté',	0.089],
			[204,	u'Marchand',	0.089],
			[205,	u'Brassard',	0.089],
			[206,	u'Forget',	0.089],
			[207,	u'Patel',	0.089],
			[208,	u'Marcotte',	0.088],
			[209,	u'Béland',	0.087],
			[210,	u'Larose',	0.086],
			[211,	u'Duval',	0.086],
			[212,	u'Archambault',	0.086],
			[213,	u'Maltais',	0.086],
			[214,	u'Trépanier',	0.085],
			[215,	u'Laliberté',	0.085],
			[216,	u'Bisson',	0.085],
			[217,	u'Brisson',	0.085],
			[218,	u'Dufresne',	0.085],
			[219,	u'Beaudry',	0.084],
			[220,	u'Chartrand',	0.084],
			[221,	u'Houde',	0.084],
			[222,	u'Fréchette',	0.084],
			[223,	u'Lafontaine',	0.084],
			[224,	u'Guillemette',	0.084],
			[225,	u'Drolet',	0.084],
			[226,	u'Vincent',	0.083],
			[227,	u'Richer',	0.083],
			[228,	u'Germain',	0.083],
			[229,	u'Larivière',	0.082],
			[230,	u'Ferland',	0.082],
			[231,	u'Trottier',	0.081],
			[232,	u'Piché',	0.081],
			[233,	u'Boulanger',	0.080],
			[234,	u'Sirois',	0.079],
			[235,	u'Charest',	0.079],
			[236,	u'Provost',	0.079],
			[237,	u'Durand',	0.079],
			[238,	u'Dumas',	0.079],
			[239,	u'Soucy',	0.079],
			[240,	u'Lamoureux',	0.079],
			[241,	u'Lachapelle',	0.079],
			[242,	u'Bégin',	0.079],
			[243,	u'Boily',	0.078],
			[244,	u'Croteau',	0.078],
			[245,	u'Savoie',	0.078],
			[246,	u'Provencher',	0.078],
			[247,	u'Prévost',	0.078],
			[248,	u'Duguay',	0.077],
			[249,	u'Lemire',	0.077],
			[250,	u'Delisle',	0.076],
			[251,	u'Desmarais',	0.076],
			[252,	u'Laberge',	0.076],
			[253,	u'Nault',	0.076],
			[254,	u'Bourgeois',	0.075],
			[255,	u'Lafrance',	0.075],
			[256,	u'Lagacé',	0.075],
			[257,	u'Daoust',	0.075],
			[258,	u'Brault',	0.074],
			[259,	u'Castonguay',	0.074],
			[260,	u'Vallières',	0.074],
			[261,	u'Pellerin',	0.074],
			[262,	u'Rivest',	0.074],
			[263,	u'Brochu',	0.074],
			[264,	u'Samson',	0.074],
			[265,	u'Lépine',	0.074],
			[266,	u'Leroux',	0.073],
			[267,	u'Larochelle',	0.073],
			[268,	u'Brousseau',	0.073],
			[269,	u'Sauvé',	0.073],
			[270,	u'Laurin',	0.073],
			[271,	u'Clément',	0.073],
			[272,	u'Bissonnette',	0.072],
			[273,	u'Lajoie',	0.072],
			[274,	u'Aubin',	0.072],
			[275,	u'Doyon',	0.072],
			[276,	u'Labrie',	0.071],
			[277,	u'Grondin',	0.071],
			[278,	u'Faucher',	0.071],
			[279,	u'Corriveau',	0.070],
			[280,	u'Tétreault',	0.070],
			[281,	u'Bourque',	0.070],
			[282,	u'Dagenais',	0.070],
			[283,	u'Ducharme',	0.070],
			[284,	u'Carrière',	0.070],
			[285,	u'Duquette',	0.070],
			[286,	u'Lafleur',	0.070],
			[287,	u'Langevin',	0.068],
			[288,	u'Corbeil',	0.068],
			[289,	u'Bourassa',	0.068],
			[290,	u'Pagé',	0.068],
			[291,	u'Trudeau',	0.068],
			[292,	u'Gaudet',	0.068],
			[293,	u'Cantin',	0.068],
			[294,	u'Goyette',	0.068],
			[295,	u'Boyer',	0.067],
			[296,	u'Francoeur',	0.067],
			[297,	u'St-Louis',	0.067],
			[298,	u'Barrette',	0.067],
			[299,	u'Vigneault',	0.067],
			[300,	u'Ouimet',	0.067],
			[301,	u'Baril',	0.066],
			[302,	u'Lafrenière',	0.066],
			[303,	u'Meunier',	0.066],
			[304,	u'Laporte',	0.066],
			[305,	u'Joseph',	0.066],
			[306,	u'Brodeur',	0.066],
			[307,	u'Legaré',	0.065],
			[308,	u'Lafond',	0.065],
			[309,	u'Ross',	0.065],
			[310,	u'Maheux',	0.065],
			[311,	u'Rondeau',	0.064],
			[312,	u'Marquis',	0.064],
			[313,	u'Bastien',	0.064],
			[314,	u'Plouffe',	0.063],
			[315,	u'Bouffard',	0.063],
			[316,	u'Lacombe',	0.063],
			[317,	u'Talbot',	0.063],
			[318,	u'Julien',	0.063],
			[319,	u'Rouleau',	0.063],
			[320,	u'Roussel',	0.062],
			[321,	u'Guérin',	0.062],
			[322,	u'Boulianne',	0.062],
			[323,	u'Beaupré',	0.062],
			[324,	u'Éthier',	0.062],
			[325,	u'Dussault',	0.062],
			[326,	u'Lamarche',	0.062],
			[327,	u'Gallant',	0.062],
			[328,	u'Gauvin',	0.062],
			[329,	u'Lamothe',	0.062],
			[330,	u'Joly',	0.061],
			[331,	u'Robichaud',	0.061],
			[332,	u'Léveillé',	0.060],
			[333,	u'Bellemare',	0.060],
			[334,	u'Huard',	0.060],
			[335,	u'Garneau',	0.060],
			[336,	u'Levasseur',	0.060],
			[337,	u'Dubuc',	0.060],
			[338,	u'Millette',	0.060],
			[339,	u'Poitras',	0.060],
			[340,	u'Rochon',	0.059],
			[341,	u'Brière',	0.059],
			[342,	u'Guimond',	0.059],
			[343,	u'Hudon',	0.059],
			[344,	u'Auclair',	0.058],
			[345,	u'Beauchemin',	0.058],
			[346,	u'Brisebois',	0.058],
			[347,	u'Godbout',	0.058],
			[348,	u'Guilbault',	0.058],
			[349,	u'Cadieux',	0.057],
			[350,	u'Brown',	0.057],
			[351,	u'Durocher',	0.057],
			[352,	u'Lamarre',	0.057],
			[353,	u'Ricard',	0.057],
			[354,	u'Monette',	0.057],
			[355,	u'Cardinal',	0.056],
			[356,	u'Tran',	0.056],
			[357,	u'St-Hilaire',	0.056],
			[358,	u'Jobin',	0.056],
			[359,	u'Daigneault',	0.056],
			[360,	u'Chamberland',	0.055],
			[361,	u'Deschamps',	0.055],
			[362,	u'Beaudin',	0.055],
			[363,	u'Henry',	0.054],
			[364,	u'Boulet',	0.054],
			[365,	u'Collin',	0.053],
			[366,	u'Sabourin',	0.053],
			[367,	u'Deslauriers',	0.053],
			[368,	u'Dumais',	0.053],
			[369,	u'Gamache',	0.053],
			[370,	u'Messier',	0.053],
			[371,	u'Beaudet',	0.053],
			[372,	u'Pilote',	0.053],
			[373,	u'Berthiaume',	0.052],
			[374,	u'Cossette',	0.052],
			[375,	u'Hamelin',	0.052],
			[376,	u'Rhéaume',	0.052],
			[377,	u'Campeau',	0.052],
			[378,	u'Mallette',	0.051],
			[379,	u'Fleury',	0.051],
			[380,	u'Patry',	0.051],
			[381,	u'St-Amand',	0.051],
			[382,	u'Gariépy',	0.051],
			[383,	u'David',	0.051],
			[384,	u'Viens',	0.051],
			[385,	u'Veillette',	0.051],
			[386,	u'Blanchard',	0.051],
			[387,	u'Binette',	0.051],
			[388,	u'Lebrun',	0.050],
			[389,	u'St-Germain',	0.050],
			[390,	u'Ladouceur',	0.050],
			[391,	u'Fiset',	0.050],
			[392,	u'Moisan',	0.050],
			[393,	u'Loiselle',	0.049],
			[394,	u'Comeau',	0.049],
			[395,	u'Mailhot',	0.049],
			[396,	u'Doré',	0.049],
			[397,	u'Déry',	0.049],
			[398,	u'Mailloux',	0.049],
			[399,	u'Forest',	0.049],
			[400,	u'Huot',	0.049],
			[401,	u'Morneau',	0.049],
			[402,	u'Allaire',	0.049],
			[403,	u'Viau',	0.049],
			[404,	u'Ayotte',	0.048],
			[405,	u'Massicotte',	0.048],
			[406,	u'Genest',	0.048],
			[407,	u'Thivierge',	0.048],
			[408,	u'Simoneau',	0.048],
			[409,	u'Robillard',	0.048],
			[410,	u'Jalbert',	0.048],
			[411,	u'Chagnon',	0.047],
			[412,	u'Pomerleau',	0.047],
			[413,	u'Leblond',	0.047],
			[414,	u'Frenette',	0.047],
			[415,	u'Aubé',	0.046],
			[416,	u'Desgagné',	0.046],
			[417,	u'Jutras',	0.046],
			[418,	u'Ruel',	0.046],
			[419,	u'Thomas',	0.046],
			[420,	u'Murray',	0.046],
			[421,	u'Bruneau',	0.046],
			[422,	u'Béliveau',	0.046],
			[423,	u'Coutu',	0.046],
			[424,	u'Lefrançois',	0.046],
			[425,	u'Lheureux',	0.046],
			[426,	u'Desroches',	0.046],
			[427,	u'Chartier',	0.045],
			[428,	u'Courchesne',	0.045],
			[429,	u'Verreault',	0.045],
			[430,	u'Brunelle',	0.045],
			[431,	u'Boulay',	0.045],
			[432,	u'Quirion',	0.045],
			[433,	u'Marcil',	0.045],
			[434,	u'Alain',	0.045],
			[435,	u'Drapeau',	0.045],
			[436,	u'Marceau',	0.045],
			[437,	u'Lizotte',	0.044],
			[438,	u'Pierre',	0.044],
			[439,	u'Bussières',	0.044],
			[440,	u'Damours',	0.044],
			[441,	u'Normand',	0.044],
			[442,	u'Prudhomme',	0.044],
			[443,	u'Lord',	0.044],
			[444,	u'Baillargeon',	0.044],
			[445,	u'Latour', 	0.044],
			[446,	u'Sévigny',	0.044],
			[447,	u'Théberge',	0.044],
			[448,	u'Plamondon',	0.043],
			[449,	u'Matte',	0.043],
			[450,	u'Cousineau',	0.043],
			[451,	u'Charland',	0.043],
			[452,	u'Rancourt',	0.043],
			[453,	u'Bonneau',	0.043],
			[454,	u'Royer',	0.043],
			[455,	u'Petit',	0.042],
			[456,	u'Lalancette',	0.042],
			[457,	u'Lanthier',	0.042],
			[458,	u'Léger',	0.042],
			[459,	u'Léonard',	0.042],
			[460,	u'St-Cyr',	0.042],
			[461,	u'Charlebois',	0.042],
			[462,	u'Paul',	0.042],
			[463,	u'Bujold',	0.042],
			[464,	u'Choquette',	0.042],
			[465,	u'McDonald',	0.042],
			[466,	u'Bélair',	0.042],
			[467,	u'Imbeault',	0.042],
			[468,	u'Pigeon',	0.041],
			[469,	u'Caouette',	0.041],
			[470,	u'Garand',	0.041],
			[471,	u'Brouillette',	0.041],
			[472,	u'Gobeil',	0.041],
			[473,	u'Pineault',	0.041],
			[474,	u'Chiasson',	0.041],
			[475,	u'Chevalier',	0.041],
			[476,	u'Dugas',	0.041],
			[477,	u'Morel',	0.041],
			[478,	u'Jones',	0.040],
			[479,	u'Tousignant',	0.040],
			[480,	u'Bibeau',	0.040],
			[481,	u'Blackburn',	0.040],
			[482,	u'Girouard',	0.040],
			[483,	u'Malo',	0.040],
			[484,	u'Marois',	0.040],
			[485,	u'Pichette',	0.040],
			[486,	u'Comtois',	0.039],
			[487,	u'Morency',	0.039],
			[488,	u'Laforest',	0.039],
			[489,	u'Sarrazin',	0.039],
			[490,	u'Isabelle',	0.039],
			[491,	u'Normandin',	0.039],
			[492,	u'Guénette',	0.039],
			[493,	u'Johnson',	0.039],
			[494,	u'Bordeleau',	0.039],
			[495,	u'Jodoin',	0.039],
			[496,	u'Groulx',	0.039],
			[497,	u'Brazeau',	0.039],
			[498,	u'Simon',	0.039],
			[499,	u'Belley',	0.038],
			[500,	u'Lebeau',	0.038],
			[501,	u'Larrivée',	0.038],
			[502,	u'Major',	0.038],
			[503,	u'Boissonneault',	0.038],
			[504,	u'Patenaude',	0.038],
			[505,	u'Alarie',	0.038],
			[506,	u'Carpentier',	0.038],
			[507,	u'Grenon',	0.038],
			[508,	u'Bossé',	0.038],
			[509,	u'Bessette',	0.038],
			[510,	u'Lajeunesse',	0.038],
			[511,	u'Barbeau',	0.038],
			[512,	u'Miller',	0.037],
			[513,	u'Masson',	0.037],
			[514,	u'Cournoyer',	0.037],
			[515,	u'Ratté',	0.037],
			[516,	u'Chrétien',	0.037],
			[517,	u'Bourgault',	0.037],
			[518,	u'Leboeuf',	0.037],
			[519,	u'Nolet',	0.037],
			[520,	u'Sylvestre',	0.037],
			[521,	u'Rainville',	0.037],
			[522,	u'Sénécal',	0.037],
			[523,	u'Chaput',	0.037],
			[524,	u'Méthot',	0.037],
			[525,	u'Desaulniers',	0.037],
			[526,	u'Lemelin',	0.037],
			[527,	u'Reid',	0.037],
			[528,	u'Lee',	0.037],
			[529,	u'Jacob',	0.036],
			[530,	u'Michel',	0.036],
			[531,	u'Désilets',	0.036],
			[532,	u'Falardeau',	0.036],
			[533,	u'Bureau',	0.036],
			[534,	u'Gignac',	0.036],
			[535,	u'Lortie',	0.036],
			[536,	u'Mélançon',	0.036],
			[537,	u'Primeau',	0.036],
			[538,	u'Bourget',	0.036],
			[539,	u'Robinson',	0.036],
			[540,	u'Chénier',	0.035],
			[541,	u'Malenfant',	0.035],
			[543,	u'Langlais',	0.035],
			[544,	u'Williams',	0.035],
			[545,	u'Lécuyer',	0.035],
			[546,	u'Carbonneau',	0.035],
			[547,	u'Charles',	0.035],
			[548,	u'Campbell',	0.035],
			[549,	u'Pinard',	0.035],
			[550,	u'Goudreau',	0.035],
			[551,	u'Riendeau',	0.034],
			[553,	u'Robidoux',	0.034],
			[554,	u'Wilson',	0.034],
			[555,	u'Hardy',	0.034],
			[556,	u'Lampron',	0.034],
			[557,	u'Jetté',	0.034],
			[558,	u'Clermont',	0.034],
			[559,	u'Groleau',	0.034],
			[560,	u'Bois',	0.033],
			[561,	u'Guertin',	0.033],
			[562,	u'Lecompte',	0.033],
			[563,	u'Héroux',	0.033],
			[564,	u'Sylvain',	0.033],
			[565,	u'Hallé',	0.033],
			[566,	u'Desormeaux',	0.033],
			[567,	u'Fraser',	0.033],
			[568,	u'Néron',	0.033],
			[570,	u'Adam',	0.033],
			[571,	u'Voyer',	0.033],
			[572,	u'Albert',	0.033],
			[573,	u'Venne',	0.033],
			[574,	u'Rochette',	0.033],
			[575,	u'Rodriguez',	0.033],
			[576,	u'Mayer',	0.033],
			[577,	u'Racicot',	0.033],
			[578,	u'Miron',	0.033],
			[579,	u'White',	0.032],
			[580,	u'Brosseau',	0.032],
			[581,	u'Lecours',	0.032],
			[582,	u'Nadon',	0.032],
			[583,	u'Pelchat',	0.032],
			[586,	u'Théorêt',	0.032],
			[587,	u'Chassé',	0.032],
			[588,	u'Pageau',	0.032],
			[589,	u'Delorme',	0.032],
			[590,	u'Jolicoeur',	0.032],
			[591,	u'Sauvageau',	0.032],
			[592,	u'Bonin',	0.032],
			[593,	u'Galarneau',	0.032],
			[594,	u'Laprise',	0.032],
			[595,	u'Mongrain',	0.032],
			[596,	u'Thompson',	0.032],
			[597,	u'Valiquette',	0.032],
			[598,	u'Carignan',	0.031],
			[599,	u'Cusson',	0.031],
			[600,	u'Le',	0.031],
			[601,	u'Dumoulin',	0.031],
			[602,	u'Babin',	0.031],
			[603,	u'Chevrier',	0.031],
			[604,	u'Latulippe',	0.031],
			[605,	u'Riopel',	0.031],
			[606,	u'Turmel',	0.031],
			[607,	u'Claveau',	0.031],
			[608,	u'Lahaie',	0.031],
			[609,	u'Pitre',	0.031],
			[610,	u'Bourdeau',	0.031],
			[611,	u'Lemaire',	0.031],
			[612,	u'Migneault',	0.031],
			[613,	u'Fecteau',	0.031],
			[614,	u'Payette',	0.031],
			[615,	u'Poisson',	0.031],
			[616,	u'Gratton',	0.030],
			[617,	u'Thiffault',	0.030],
			[618,	u'Scott',	0.030],
			[619,	u'Cayer',	0.030],
			[620,	u'Garceau',	0.030],
			[621,	u'Boisclair',	0.030],
			[622,	u'Belzile',	0.030],
			[623,	u'Blain',	0.030],
			[625,	u'Bernatchez',	0.030],
			[626,	u'Laramée',	0.029],
			[627,	u'Mainville',	0.029],
			[628,	u'Deneault',	0.029],
			[629,	u'Beauvais',	0.029],
			[630,	u'Bigras',	0.029],
			[631,	u'Cliche',	0.029],
			[632,	u'Parenteau',	0.029],
			[633,	u'Prince',	0.029],
			[634,	u'Clarke',	0.029],
			[635,	u'Lacoste',	0.029],
			[636,	u'Dessureault',	0.029],
			[637,	u'Roch',	0.029],
			[638,	u'Bourgoin',	0.029],
			[639,	u'Singh',	0.029],
			[640,	u'Boileau',	0.029],
			[641,	u'Péloquin',	0.029],
			[642,	u'Lespérance',	0.029],
			[643,	u'Descôteaux',	0.029],
			[644,	u'Arbour',	0.029],
			[645,	u'Roux',	0.029],
			[646,	u'Joyal',	0.029],
			[647,	u'Chicoine',	0.029],
			[648,	u'Dubeau',	0.029],
			[649,	u'Kelly',	0.029],
			[650,	u'Beauchesne',	0.029],
			[651,	u'Joncas',	0.028],
			[652,	u'Lopez',	0.028],
			[653,	u'Lafortune',	0.028],
			[654,	u'Chénard',	0.028],
			[655,	u'Routhier',	0.028],
			[656,	u'Bellavance',	0.028],
			[657,	u'Moore',	0.028],
			[658,	u'Brien',	0.028],
			[659,	u'Hubert',	0.028],
			[660,	u'Maurice',	0.028],
			[661,	u'Guindon',	0.028],
			[662,	u'Touchette',	0.028],
			[663,	u'Dubreuil',	0.027],
			[664,	u'Santerre',	0.027],
			[665,	u'Pronovost',	0.027],
			[666,	u'Courtemanche',	0.027],
			[667,	u'Deshaies',	0.027],
			[668,	u'Chalifoux',	0.027],
			[669,	u'Sigouin',	0.027],
			[670,	u'Brouillard',	0.027],
			[671,	u'Goyer',	0.027],
			[672,	u'Harrisson',	0.027],
			[673,	u'Longpré',	0.027],
			[674,	u'Rémillard',	0.027],
			[675,	u'Filiatrault',	0.027],
			[676,	u'Verville',	0.027],
			[677,	u'Bérard',	0.027],
			[678,	u'Vermette',	0.027],
			[679,	u'Rocheleau',	0.027],
			[680,	u'Cohen',	0.027],
			[681,	u'Bourdon',	0.027],
			[682,	u'Duchesneau',	0.027],
			[683,	u'Anctil',	0.027],
			[684,	u'Aubry',	0.027],
			[685,	u'Wong',	0.027],
			[686,	u'Goupil',	0.027],
			[687,	u'Lamy',	0.027],
			[688,	u'Verret',	0.026],
			[689,	u'Fafard',	0.026],
			[690,	u'Montpetit',	0.026],
			[691,	u'Deblois',	0.026],
			[692,	u'Boutet',	0.026],
			[693,	u'Quesnel',	0.026],
			[694,	u'Gareau',	0.026],
			[695,	u'Corbin',	0.026],
			[696,	u'Haché',	0.026],
			[697,	u'Taylor',	0.026],
			[698,	u'Amyot',	0.026],
			[699,	u'Lalande',	0.026],
			[700,	u'Bourdages',	0.026],
			[701,	u'Bazinet',	0.026],
			[702,	u'Jolin',	0.026],
			[703,	u'Marleau',	0.026],
			[704,	u'Flamand',	0.026],
			[705,	u'Grimard',	0.026],
			[706,	u'Perrier',	0.026],
			[707,	u'Nantel',	0.025],
			[708,	u'Rhéault',	0.025],
			[710,	u'Young',	0.025],
			[711,	u'Couturier',	0.025],
			[712,	u'Toupin',	0.025],
			[713,	u'Beaumont',	0.025],
			[714,	u'Hétu',	0.025],
			[715,	u'Gauvreau',	0.025],
			[716,	u'Deveault',	0.025],
			[717,	u'Fleurant',	0.025],
			[718,	u'Desautels',	0.025],
			[719,	u'Guy',	0.025],
			[720,	u'Racette',	0.025],
			[721,	u'Tourigny',	0.025],
			[722,	u'Chayer',	0.025],
			[723,	u'Danis',	0.025],
			[724,	u'Duclos',	0.025],
			[725,	u'Foisy',	0.025],
			[726,	u'Loyer',	0.025],
			[727,	u'Valois',	0.025],
			[728,	u'Couillard',	0.025],
			[729,	u'Laverdière',	0.025],
			[730,	u'Meilleur',	0.025],
			[731,	u'Dorval',	0.025],
			[732,	u'Khan',	0.025],
			[733,	u'Murphy',	0.025],
			[734,	u'Forgues',	0.025],
			[735,	u'Otis',	0.024],
			[736,	u'Dorion',	0.024],
			[737,	u'Phaneuf',	0.024],
			[738,	u'Awashish',	0.024],
			[739,	u'Charpentier',	0.024],
			[740,	u'Champoux',	0.024],
			[741,	u'Desmeules',	0.024],
			[742,	u'Mitchell',	0.024],
			[743,	u'Arcand',	0.024],
			[744,	u'Tellier',	0.024],
			[745,	u'Anderson',	0.024],
			[746,	u'Allen',	0.024],
			[747,	u'Baron',	0.024],
			[748,	u'Baribeau',	0.024],
			[749,	u'Chapdelaine',	0.024],
			[750,	u'Bacon',	0.024],
			[751,	u'Chan',	0.024],
			[752,	u'Métivier',	0.024],
			[753,	u'Fradette',	0.024],
			[754,	u'Ranger',	0.024],
			[755,	u'Després',	0.024],
			[756,	u'Lesage',	0.024],
			[757,	u'Poliquin',	0.024],
			[758,	u'Généreux',	0.024],
			[759,	u'Papineau',	0.024],
			[760,	u'Frappier',	0.024],
			[761,	u'Latreille',	0.024],
			[762,	u'Meloche',	0.024],
			[763,	u'Gouin',	0.023],
			[764,	u'Crête',	0.023],
			[765,	u'Pedneault',	0.023],
			[766,	u'Berger',	0.023],
			[767,	u'Briand',	0.023],
			[768,	u'Olivier',	0.023],
			[769,	u'Truchon',	0.023],
			[770,	u'Sénéchal',	0.023],
			[771,	u'Lavergne',	0.023],
			[772,	u'Rochefort',	0.023],
			[773,	u'Lelièvre',	0.023],
			[774,	u'Gaumond',	0.023],
			[775,	u'Roussy',	0.023],
			[776,	u'René',	0.023],
			[777,	u'Pham',	0.023],
			[778,	u'Dasilva',	0.023],
			[779,	u'McKenzie',	0.023],
			[780,	u'Marion',	0.023],
			[781,	u'Sergerie',	0.023],
			[782,	u'Dostie',	0.022],
			[783,	u'Madore',	0.022],
			[784,	u'Mongeau',	0.022],
			[785,	u'Crevier',	0.022],
			[786,	u'Faubert',	0.022],
			[787,	u'Paiement',	0.022],
			[788,	u'Bousquet',	0.022],
			[789,	u'Favreau',	0.022],
			[790,	u'Gill',	0.022],
			[791,	u'Juneau',	0.022],
			[792,	u'Paris',	0.022],
			[793,	u'Beausoleil',	0.022],
			[794,	u'Boilard',	0.022],
			[795,	u'Adams',	0.022],
			[796,	u'Bellefleur',	0.022],
			[797,	u'Poissant',	0.022],
			[798,	u'Gonzalez',	0.022],
			[799,	u'Laframboise',	0.022],
			[800,	u'Ringuette',	0.022],
			[801,	u'Garon',	0.022],
			[802,	u'Marier',	0.022],
			[803,	u'Desnoyers',	0.022],
			[804,	u'Li',	0.022],
			[805,	u'Perras',	0.022],
			[806,	u'Déziel',	0.022],
			[807,	u'Gascon',	0.022],
			[808,	u'Crépeau',	0.021],
			[809,	u'Galipeau',	0.021],
			[810,	u'Garcia',	0.021],
			[811,	u'Kaur',	0.021],
			[812,	u'Coderre',	0.021],
			[813,	u'Huynh',	0.021],
			[814,	u'Milot',	0.021],
			[815,	u'Tassé',	0.021],
			[816,	u'Hernandez',	0.021],
			[817,	u'Marin',	0.021],
			[818,	u'Hénault',	0.021],
			[819,	u'Lehoux',	0.021],
			[820,	u'Robertson',	0.021],
			[821,	u'Taillon',	0.021],
			[822,	u'Bisaillon',	0.021],
			[823,	u'Laperrière',	0.021],
			[824,	u'Vinet',	0.021],
			[825,	u'Cartier',	0.021],
			[826,	u'Pothier',	0.021],
			[828,	u'Munger',	0.021],
			[829,	u'Angers',	0.021],
			[830,	u'Audy',	0.021],
			[831,	u'Dulude',	0.021],
			[832,	u'Ledoux',	0.021],
			[833,	u'Pruneau',	0.021],
			[834,	u'Bond',	0.021],
			[835,	u'Beauséjour',	0.021],
			[836,	u'Biron',	0.021],
			[837,	u'Banville',	0.021],
			[838,	u'Pinette',	0.021],
			[839,	u'Martinez',	0.021],
			[840,	u'Perez',	0.021],
			[841,	u'Dumouchel',	0.020],
			[842,	u'Labranche',	0.020],
			[843,	u'Trahan',	0.020],
			[844,	u'Laviolette',	0.020],
			[845,	u'Bénard',	0.020],
			[846,	u'Hains',	0.020],
			[847,	u'Gaulin',	0.020],
			[848,	u'Lacoursière',	0.020],
			[849,	u'Guérard',	0.020],
			[850,	u'Pratte',	0.020],
			[851,	u'Duhamel',	0.020],
			[852,	u'Dufort',	0.020],
			[853,	u'Nolin',	0.020],
			[854,	u'Lupien',	0.020],
			[855,	u'Rouillard',	0.020],
			[856,	u'Dupéré',	0.020],
			[857,	u'Choinière',	0.020],
			[858,	u'Turbide',	0.020],
			[859,	u'Vanier',	0.020],
			[860,	u'Aubut',	0.020],
			[861,	u'Dupras',	0.020],
			[862,	u'Belleau',	0.020],
			[863,	u'Davis',	0.020],
			[864,	u'Lacelle',	0.020],
			[865,	u'Blondin',	0.020],
			[866,	u'Harnois',	0.020],
			[867,	u'Laferrière',	0.020],
			[868,	u'Surprenant',	0.020],
			[869,	u'Bougie',	0.019],
			[870,	u'Collard',	0.019],
			[871,	u'Hamilton',	0.019],
			[872,	u'Fauteux',	0.019],
			[873,	u'Gendreau',	0.019],
			[874,	u'Cabana',	0.019],
			[875,	u'Gougeon',	0.019],
			[876,	u'Maisonneuve',	0.019],
			[877,	u'Bouthillier',	0.019],
			[878,	u'Quenneville',	0.019],
			[879,	u'Bourbonnais',	0.019],
			[880,	u'Maillé',	0.019],
			[881,	u'Morand',	0.019],
			[882,	u'Béchard',	0.019],
			[883,	u'Bellerose',	0.019],
			[884,	u'Nicolas',	0.019],
			[885,	u'Taillefer',	0.019],
			[886,	u'Caissy',	0.019],
			[887,	u'Lanctôt',	0.019],
			[888,	u'Cadorette',	0.019],
			[889,	u'Lirette',	0.019],
			[890,	u'Diotte',	0.019],
			[891,	u'Fernandez',	0.019],
			[892,	u'Roger',	0.019],
			[893,	u'Lachaîne',	0.019],
			[894,	u'Théroux',	0.019],
			[895,	u'Lauzier',	0.019],
			[896,	u'Beaumier',	0.019],
			[897,	u'Duhaime',	0.019],
			[898,	u'Giasson',	0.019],
			[899,	u'Lewis',	0.019],
			[900,	u'Limoges',	0.019],
			[901,	u'Cameron',	0.019],
			[902,	u'Canuel',	0.019],
			[903,	u'McLean',	0.019],
			[904,	u'Dastous',	0.019],
			[905,	u'Daviault',	0.019],
			[906,	u'Dunn',	0.019],
			[907,	u'Chen',	0.018],
			[908,	u'Diamond',	0.018],
			[909,	u'Stewart',	0.018],
			[910,	u'Jourdain',	0.018],
			[911,	u'Poudrier',	0.018],
			[912,	u'Doyle',	0.018],
			[913,	u'Normandeau',	0.018],
			[914,	u'Lacerte',	0.018],
			[915,	u'Nicol',	0.018],
			[916,	u'Décarie',	0.018],
			[917,	u'Louis',	0.018],
			[918,	u'Roberts',	0.018],
			[919,	u'Pearson',	0.018],
			[920,	u'Walker',	0.018],
			[921,	u'Dansereau',	0.018],
			[922,	u'Pereira',	0.018],
			[923,	u'Lévy',	0.018],
			[924,	u'Montreuil',	0.018],
			[925,	u'Dalpé',	0.018],
			[926,	u'Lacharité',	0.018],
			[927,	u'Letendre',	0.018],
			[928,	u'Vandal',	0.018],
			[929,	u'Daneau',	0.018],
			[930,	u'Mireault',	0.018],
			[931,	u'Ahmed',	0.018],
			[932,	u'Desfossés',	0.018],
			[933,	u'Belhumeur',	0.018],
			[934,	u'Gemme',	0.018],
			[935,	u'Jomphe',	0.018],
			[936,	u'Langelier',	0.018],
			[937,	u'Magnan',	0.018],
			[938,	u'Saucier',	0.018],
			[939,	u'Brissette',	0.017],
			[940,	u'Collins',	0.017],
			[941,	u'Ly',	0.017],
			[942,	u'Ruest',	0.017],
			[943,	u'Hélie',	0.017],
			[944,	u'Lapalme',	0.017],
			[945,	u'Gordon',	0.017],
			[946,	u'Bourbeau',	0.017],
			[947,	u'Gonthier',	0.017],
			[948,	u'Riverin',	0.017],
			[949,	u'Toussaint',	0.017],
			[950,	u'April',	0.017],
			[951,	u'Diaz',	0.017],
			[952,	u'Manseau',	0.017],
			[953,	u'Bachand',	0.017],
			[954,	u'Hurtubise',	0.017],
			[955,	u'King',	0.017],
			[956,	u'Alexandre',	0.017],
			[957,	u'Bleau',	0.017],
			[958,	u'Mark',	0.017],
			[959,	u'Beaucage',	0.017],
			[960,	u'Cauchon',	0.017],
			[961,	u'Neveu',	0.017],
			[962,	u'Painchaud',	0.017],
			[963,	u'Quintal',	0.017],
			[964,	u'Rose',	0.017],
			[965,	u'Dupré',	0.017],
			[966,	u'Morais',	0.017],
			[967,	u'Legros',	0.017],
			[968,	u'Pharand',	0.017],
			[969,	u'Boisjoli',	0.017],
			[970,	u'François',	0.017],
			[971,	u'Cardin',	0.017],
			[972,	u'Quévillon',	0.017],
			[973,	u'Bergevin',	0.017],
			[974,	u'Levac',	0.017],
			[975,	u'Kirouac',	0.017],
			[976,	u'Busque',	0.017],
			[977,	u'Constantineau',	0.017],
			[978,	u'Delâge',	0.017],
			[979,	u'Valcourt',	0.017],
			[980,	u'Montminy',	0.017],
			[981,	u'Doiron',	0.017],
			[982,	u'Sauriol',	0.017],
			[983,	u'Savage',	0.016],
			[984,	u'Soulières',	0.016],
			[985,	u'Deraspe',	0.016],
			[986,	u'Grant',	0.016],
			[987,	u'Guérette',	0.016],
			[988,	u'Lam',	0.016],
			[989,	u'Loranger',	0.016],
			[990,	u'Hogue',	0.016],
			[991,	u'Carle',	0.016],
			[992,	u'Ferron',	0.016],
			[993,	u'Lemoine',	0.016],
			[994,	u'Frigon',	0.016],
			[995,	u'Juteau',	0.016],
			[996,	u'Forcier',	0.016],
			[997,	u'Pinsonneault',	0.016],
			[998,	u'Hervieux',	0.016],
			[999,	u'Daraiche',	0.016],
			[1000,	u'McDuff',	0.016]]
