package TestUnitarios;


import org.junit.Test;
import uy.edu.um.adt.hashCerrado.hash;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HashTest {

    
        @Test
        public void CincoColisionesPut(){
            hash<Integer,String> hash= new hash<>();
            hash.put(9,"Primero");
            hash.put(20,"Segundo");
            hash.put(31,"Tercero");
            hash.put(42,"Cuarto");
            hash.put(53,"Quinto");
            hash.ShowHash();
            assertEquals(hash.getCapacity(),5);
        }

        @Test
        public void cienPuts(){
            hash<Integer,String> hash= new hash<>();
            for (int i=0; i<100; i++){
                hash.put(i,"No importa el valor");
            }
            assertEquals(hash.getCapacity(),100);
        }

        @Test
        public void cienContains(){
            hash<Integer,String> hash= new hash<>();
            for (int i=0; i<50; i++){
                hash.put(i,"No importa el valor");
            }    
            for (int j=100; j>=50; j--){
                hash.put(j,"No importa el valor");
            }    
            for (int k=0; k<100; k++){
                assertTrue(hash.contains(k));
            }
            assertFalse(hash.contains(1375307));

        }

        @Test
        public void Remove_Contains(){
            hash<Integer,String> hash= new hash<>();
            hash.put(4, "Primero");
            hash.put(5,"Segundo");
            hash.put(15,"Este deberia ir en donde esta primero, no puede porque ya esta ocupado, va al segundo, esta ocupado, por ultimo se tiene que poner en el lugar de abajo del segundo");
            hash.remove(4);
            assertTrue(hash.contains(15));
            assertFalse(hash.contains(4));
        
        } 

        @Test
        public void capacityTras50Removes(){
            hash<Integer,String> hash= new hash<>();
            for (int i=0; i<100; i++){
                hash.put(i,"No importa el valor");
            }
            for (int j=0; j<50; j++){
                hash.remove(j);
            }
            assertEquals(hash.capacity, 100);
            //La razon por la que la capacidad es 100 es porque a pesar
            //De que se borraron los elementos, estos siguen estando ahi una vez que se 
            //haga rehash realmente seran borrados. Por eso esta bien que la capacidad sea 100 
        }

      


    }

