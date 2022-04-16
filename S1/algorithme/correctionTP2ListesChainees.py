#coding:utf-8
class Noeud:
    def __init__(self,valeur,suivant=None):
        """constructeur de classe
        permet l'allocation de la mémoire requise et
        l'initialisation des données valleur et suivant de l'objet"""
        self.valeur = valeur
        self.suivant = suivant


def afficheListe(L):
    """affiche la valeur des noeuds de la liste L"""
    compteur = 1
    while L !=None:
        print ("Le noeud ", compteur, " a la valeur ",L.valeur)
        L = L.suivant
        compteur +=1
    print("")

def insererDebut(L,x):
    """ Fonction insérant un nouveau noeud de valeur x au début de la liste L """
    return Noeud(x,L)


def insererFinIt(L, x):
    """Fonction itérative insérant un nouveau noeud de valeur x à la fin de la liste L"""
    if L == None:
        return Noeud(x)
    tmp = L
    while tmp.suivant != None:   
        tmp = tmp.suivant
    tmp.suivant = Noeud(x)
    return L


def rechercheRec(L, x):
    """Fonction récursive retournant l'adresse (le pointeur sur le noeud) du premier noeud contenant la valeur x.
  On retourne NULL lorsque la liste ne contient pas la valeur x""" 
    if L == None:
        return None 
    if L.valeur == x:
        return L
    return rechercheRec(L.suivant, x)


def insererFinRec(L, x):
    """Fonction itérative insérant un nouveau noeud de valeur x à la fin de la liste L"""
    if L == None:
        return Noeud(x)
    L.suivant = insererFinRec(L.suivant, x)
    return L

def rechercheIt(L, x): 
"""Fonction itérative retournant l'adresse (le pointeur sur le noeud) du premier noeud contenant la valeur x.
  On retourne NULL lorsque la liste ne contient pas la valeur x""" 
    if L == None:
        return None
    tmp = L
    while tmp != None:
        if tmp.valeur == x:
            return tmp
        tmp = tmp.suivant
    return None


def insereApres(L, x, y):
""" Fonction insérant un nouveau noeud avec la valeur y après le premier noeud contenant la valeur x.
S'il n'y a pas de noeud contenant la valeur x, cette fonction ne fait rien.  
On utilise la fonction rechercheIt pour déterminer l'adresse du noeud contenant la valeur x  """ 

tmp = rechercheIt(L, x)
    if tmp != None:
        tmp.suivant = Noeud(y, tmp.suivant)
    return L


def insereAvant(L, x, y):
    """Fonction insérant un nouveau noeud avec la valeur y avant le premier noeud contenant la valeur x.
S'il n'y a pas de noeud contenant la valeur x, cette fonction ne fait rien.  
Astuce : on reprend la fonction insereApres et on échange les valeurs x et y """

    tmp = rechercheRec(L, x)
    
    if tmp != None:
        tmp.suivant = Noeud(y, tmp.suivant)
        tmp.valeur, tmp.suivant.valeur = tmp.suivant.valeur, tmp.valeur
    return L


maListe = Noeud(52,Noeud(8,Noeud(2,Noeud(5,Noeud(23)))))  
afficheListe(maListe)
