from PIL import Image

swap = lambda x: (x[1], x[0])
sign = lambda x: (1, -1) [x < 0]


class Arista:
    def __init__(self, yMax, xYmin, mi):
        self.yMax = yMax
        self.xYmin = xYmin
        self.mi = mi
        self.str = "Arista (yMax:%s xYmin:%s mi:%s)" % (self.yMax, self.xYmin, self.mi)
    def __repr__(self):
        return self.str
    def __str__(self):
        return self.str
    def updateXYmin(self):
        self.xYmin += self.mi


def linea(x1, y1, x2, y2, color = (0, 0, 0)):
    dx, dy = x2 - x1, y2 - y1
    incXi, incYi = sign(dx), sign(dy)
    dx, dy = abs(dx), abs(dy)
    incXr, incYr = 0, 0
    if dx < dy:
        incYr = incYi
        dx, dy = swap((dx, dy))
    else:
        incXr = incXi
    x, y = x1, y1
    incR = 2 * dy
    inc = incR - dx
    incI = inc - dx
    while x != x2 or y != y2:
        im.putpixel((x, y), color)
        if inc >= 0:
            x += incXi
            y += incYi
            inc += incI
        else:
            x += incXr
            y += incYr
            inc += incR
    im.putpixel((x, y), color)


def drawPolygon(pu, color = (0, 0, 0)):
    for (x1, y1), (x2, y2) in zip(pu[:], pu[1::] + pu[:1:]):
        linea(x1, y1, x2, y2, color)


def fillPolygon(pu, color = (0, 0, 0)):

    activos = []
    aristas = {}

    for (x1, y1), (x2, y2) in zip(pu[:], pu[1::] + pu[:1:]):
        if y2 != y1:
            mi = (x2 - x1) / ((y2 - y1) * 1.0) if x2 != x1 else 0.0
            if y1 > y2:
                li = y2
                ar = Arista(y1, x2, mi)
            else:
                li = y1
                ar = Arista(y2, x1, mi)
            if li not in aristas:
                aristas[li] = []
            aristas[li].append(ar)


    for li in range (0, 500):
        if li in aristas:
            for bk in aristas[li]:
                activos.append(Arista(bk.yMax, bk.xYmin, bk.mi))

        activos[:] = sorted([bk for bk in activos if not bk.yMax == li], key = lambda ar: ar.xYmin)

        x1 = 0
        x2 = 0
        ymax1 = 0
        ymax2 = 0
        count = 0
        fill = False;
        for ar in activos:
            if count % 2 == 0:
                x1 = int(round(ar.xYmin))
                ymax1 = ar.yMax
                if x1 == x2:
                    if (x1 == ymax1 and x2 != ymax2) or (x1 != ymax1 and x2 == ymax2):
                        x2 = x1
                        ymax2 = ymax1
                    else:
                        count += 1
                else:
                    count += 1
            else:
                x2 = int(round(ar.xYmin))
                ymax2 = ar.yMax
                fill = False;
                if x1 == x2:
                    if (x1 == ymax1 and x2 != ymax2) or (x1 != ymax1 and x2 == ymax2):
                        x2 = x1
                        ymax2 = ymax1
                    else:
                        fill = True
                        count += 1
                else:
                    fill = True
                    count += 1
                if fill:
                    linea(x1, li, x2, li, color)
            ar.updateXYmin()




im = Image.new('RGBA', (500, 500), (255, 255, 255, 0)) 



puntos = [(50, 250), (150, 50), (250, 200), (350, 50), (450, 250), (400, 450), (300, 350), (200, 350), (100, 450)]
fillPolygon(puntos, (0, 0, 255))

puntos = [(180, 30), (400, 170), (400, 370), (220, 480), (90, 230)]
drawPolygon(puntos, (255, 0, 255))

im.show()
