package de.dhbwka.java.exercise.Semester_1.Vererbung2;

public class PeriodicTable {

    //Element[] elements = new Element[8];

    //Methoden
    //Main-Methode
    public static void main(String[] args){
        Element[] elements = new Element[8];
        elements[0] = new Element("Wasserstoff", "H", 1, 'K', 1, true);
        elements[1] = new Element("Helium", "He", 2, 'K', 1, true);
        elements[2] = new Element("Natrium", "Na", 11, 'M', 3, true);
        elements[3] = new Metal("Eisen", "Fe", 26, 'N', 3, false, false, 21);
        elements[4] = new Metal("Germanium", "Ge", 32, 'N', 3, false, false, 10.02);
        elements[5] = new Element("Brom", "Br", 35, 'N', 2, true);
        elements[6] = new Metal("Tellur", "Te", 52, 'O', 3, true, true, 0.005);
        elements[7] = new Metal("Gold", "Au", 79, 'P', 3, false, false, 44);

        elements.toString();
    }
/*
    //weitere Methoden
    public void addElement(Element e){
        if(hasElement(e) == false){
            elements[elements.length+1] = new Element(e.getName(), e.getSymbol(), e.getOrdinal(), e.getShell(), e.getPhase(), e.isMain());
        }
    }

    public boolean hasElement(Element e){
        boolean alreadyDefined = false;
        for(int i=0; i>elements.length; i++){
            if(e.ordinal == elements[i].ordinal){
                alreadyDefined = true;
            }
        }
        return alreadyDefined;
    }

    public Element getElement(int o){
        return elements[o];
    }

    public Element[] getMetals(){
        Element[] metals = new Element[5];
        for(int i =0; i<elements.length; i++){
            if (elements[i].phase == 1){
                metals[metals.length +1]= new Element(elements[i].getName(), elements[i].getSymbol(), elements[i].getOrdinal(), elements[i].getShell(), elements[i].getPhase(), elements[i].isMain());
            }
        }
        return metals;
    }*/
}

