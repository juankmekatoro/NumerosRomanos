/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udea.appempresariales;

/**
 *
 * @author Admin
 */
public class ConversorRomanos {

    int contadorI = 0;
    int contadorV = 0;
    int contadorX = 0;
    int contadorL = 0;
    int contadorC = 0;
    int contadorD = 0;
    int contadorM = 0;

    
    public int transformar(String romano)
    {
        int resultado = 0;
        int actual;
        int siguiente;
        int iguales=0;
        boolean anterior = false;
        if(noIXCMRepetidas(romano) && soloRomanos(romano) && noVLDRepetidas(romano))
        {
            if(romano.length()==1)
            {
                 resultado = reconocerCaracter(romano.charAt(0));
            }
            else
            {
                for(int i=0;i<romano.length()-1;i++)
                {
                    char c = romano.charAt(i);
                    actual = reconocerCaracter(c);
                    siguiente = reconocerCaracter(romano.charAt(i+1));
                    if(actual < siguiente)
                    {
                        if(iguales == 0)
                        {
                            if(actual==1)
                                anterior=iAntesXV(siguiente);
                            else if(actual==10)
                                anterior=xAntesLC(siguiente);
                            else if(actual==100)
                                anterior=cAntesDM(siguiente);
                            else if(actual==5 && siguiente>5)
                                anterior=false;
                            
                            if(anterior)
                            resultado = resultado - actual;
                            else
                                return -1;
                        }
                        else
                        {
                            return -1;
                        }
                    }
                    else if(actual > siguiente)
                    {
                        resultado = resultado + actual;
                        iguales=0;
                    }
                    else if(actual==siguiente)
                    {
                        resultado = resultado + actual;
                        iguales=iguales+1;
                    }
                }
                siguiente = reconocerCaracter(romano.charAt(romano.length()-1));
                resultado = resultado + siguiente;
            }
            return resultado; 
        }
        else
        {
            return -1;
        }
        
    }
    
    public boolean noIXCMRepetidas(String romano)
    {
        boolean resultado = false;
        int bandera =0;
        for(int i=0; i<romano.length();i++)
        {
            if(bandera==0)
            {
                char letra = romano.charAt(i);
                switch(letra)
                {
                    case 'I':
                    case 'i':
                        if(contadorI==3)
                        {
                            resultado = false;
                            bandera=1;
                        }
                        else
                        {
                            contadorI= contadorI+1;
                            contadorX=0;
                            contadorC=0;
                            contadorM=0;
                            resultado = true; 
                        }
                    break;
                        
                    case 'X':
                    case 'x':
                        
                        if(contadorX==3)
                        {
                            resultado = false;
                            bandera=1;
                        }
                        else
                        {
                            contadorX= contadorX+1;
                            contadorI = 0;
                            contadorC = 0;
                            contadorM = 0;
                            resultado = true; 
                        }
                    break;
                        
                    case 'c':
                    case 'C':
                        
                        if(contadorC==3)
                        {
                            resultado = false;
                            bandera=1;
                        }
                        else
                        {
                            contadorC= contadorC+1;
                            contadorI = 0;
                            contadorX = 0;
                            contadorM = 0;
                            resultado = true; 
                        }
                    break;
                        
                    case 'M':
                    case 'm':
                        
                        if(contadorM==3)
                        {
                            resultado = false;
                            bandera=1;
                        }
                        else
                        {
                            contadorM= contadorM+1;
                            contadorI = 0;
                            contadorX = 0;
                            contadorC = 0;
                            resultado = true; 
                        }
                    break;
                        
                    default:
                        contadorI = 0;
                        contadorX = 0;
                        contadorC = 0;
                        contadorM = 0;
                        break;
                }
            }
            else
                break;
        }
        if(contadorI==0 && contadorX==0 && contadorC == 0 && contadorM == 0)
        {
            resultado=true;
        }
        return resultado;
    }
    
    public boolean noVLDRepetidas(String romano)
    {
        boolean resultado = false;
        int bandera =0;
        for(int i=0; i<romano.length();i++)
        {
            if(bandera==0)
            {
                char letra = romano.charAt(i);
                switch(letra)
                {
                    case 'V':
                    case 'v':
                        if(contadorV==1)
                        {
                            resultado = false;
                            bandera=1;
                        }
                        else
                        {
                            contadorV= contadorV+1;
                            contadorL=0;
                            contadorD=0;
                            resultado = true; 
                        }
                    break;
                        
                    case 'L':
                    case 'l':
                        
                        if(contadorL==1)
                        {
                            resultado = false;
                            bandera=1;
                        }
                        else
                        {
                            contadorL= contadorL+1;
                            contadorV = 0;
                            contadorD = 0;
                            resultado = true; 
                        }
                    break;
                        
                    case 'D':
                    case 'd':
                        
                        if(contadorD==1)
                        {
                            resultado = false;
                            bandera=1;
                        }
                        else
                        {
                            contadorD= contadorD+1;
                            contadorV = 0;
                            contadorL = 0;
                            resultado = true; 
                        }
                    break;
                        
                    default:
                        contadorV=0;
                        contadorL=0;
                        contadorD=0;
                        break;
                }
            }
            else
                break;
        }
        if(contadorV==0 && contadorL==0 && contadorD == 0)
        {
            resultado=true;
        }
        return resultado;
    }
    
    public boolean soloRomanos(String romano)
    {
        boolean resultado = false;
        int contadorV=0;
        int bandera = 0;
        for(int i=0; i<romano.length();i++)
        {
            if(bandera==0)
            {
                char c = romano.charAt(i);
                switch(c)
                {
                    case 'V':
                    case 'v':
                        contadorV++;
                    case 'I':
                    case 'i':
                    case 'X':
                    case 'x':
                    case 'L':
                    case 'l':
                    case 'c':
                    case 'C':
                    case 'D':
                    case 'd':
                    case 'M':
                    case 'm':
                        resultado = true;
                        break;
                    default:
                        resultado = false;
                        bandera = 1;
                        break;
                }
            }
            else
                break;
        }
        if(contadorV >=2)
           resultado = false;
        return  resultado;
    }
    
    public int reconocerCaracter(char caracter)
    {
        int resultado=0;
        switch(caracter)
        {
            case 'I':
            case 'i':
                resultado= 1;
                break;
            case 'V':
            case 'v':
                resultado= 5;
                break;
            case 'X':
            case 'x':
                resultado = 10;
                break;
            case 'L':
            case 'l':
                resultado = 50;
                break;
            case 'C':
            case 'c':
                resultado = 100;
                break;
            case 'D':
            case 'd':
                resultado = 500;
                break;
            case 'M':
            case 'm':
                resultado = 1000;
                break;
        }
        return resultado;
    }
    
    public boolean iAntesXV (int siguiente)
    {
        return (siguiente==5  || siguiente==10);

    }
    
    public boolean xAntesLC (int siguiente)
    {
        return (siguiente==50 || siguiente==100);
    }
    
    public boolean cAntesDM (int siguiente)
    {
        return (siguiente==500 || siguiente==1000);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConversorRomanos cv = new ConversorRomanos();
        int res = cv.transformar("ix");
        if(res==-1)
            System.out.println("El termino ingresado no se puede operar");
        else
            System.out.println(res);
    }
    
}
