package src.uy.edu.um.adt.hashCerrado;
import src.uy.edu.um.adt.linkedlist.MyLinkedListImpl;
import src.uy.edu.um.adt.linkedlist.MyList;

import java.util.Vector;
import java.util.ArrayList;





public class hash<K,V> implements hashInterfaze<K,V>{
    //Vamos a lidiear linealmente con las colisiones 
    
    Vector<HashNode<K, V>> Hash;
    private int tableSize;
    public int capacity;
    
 

    public hash(int value){
        capacity=0;
        tableSize=value;
        Hash= new Vector<>(tableSize);
        for (int i = 0; i < tableSize; i++) {
            Hash.add(null);}
    }   
    
    
    //Listo
    public void put(K key, V value){
        HashNode<K,V> nuevoHashNode= new HashNode<K,V>(key, value);
        int LugarDelHash=HashFunction(key);
        
    
        
        //Tenemos que ver que el Lugar insertado este vacio
        while(Hash.get(LugarDelHash) !=null){
            LugarDelHash=LugarDelHash+1;
            if (LugarDelHash >= tableSize){
                LugarDelHash=0;
            }
                
        }
        Hash.set(LugarDelHash,nuevoHashNode);
        this.capacity+=1;
        int percentage_capacity=((capacity*100)/tableSize);

        //Hacer rehashing cuando el hash es muy grande 
        if(percentage_capacity>=75){
            this.Rehash();
            
            int tamanioReal=0;
            for(int i=0;i<tableSize;i++){
                if (this.Hash.get(i) != null && this.Hash.get(i).borrado==false){
                tamanioReal+=1; }
            }
            this.capacity=tamanioReal;
        }

    }
    //Listo
    public boolean contains(K key){
        boolean resultado=false;
        int obtenido= HashFunction(key);
        while(this.Hash.get(obtenido) != null){
            if (this.Hash.get(obtenido).key == key && this.Hash.get(obtenido).borrado== false){
                resultado= true;
                break;
            }
            obtenido=obtenido+1;
            if (obtenido >= tableSize){
                obtenido=0;
            }
        
        }
        return resultado;    
    }
    //Listo
    public void remove(K clave){
        int indiceDelBorrado= HashFunction(clave);
        while(Hash.get(indiceDelBorrado) !=null){
            if (this.Hash.get(indiceDelBorrado).key==clave){
                this.Hash.get(indiceDelBorrado).borrado=true;
                break;
            }    
            indiceDelBorrado=indiceDelBorrado+1;
            if (indiceDelBorrado >= tableSize){
                indiceDelBorrado=0;
            }
        }         
    }
    //Listo
    private void Rehash(){
        NextPrimo np = new NextPrimo();
        int tablesizeVIEJO=this.tableSize;
        this.tableSize= np.nextPrimo(tableSize*2);
        
        Vector<HashNode<K,V>> Hash_nuevo= new Vector<>(tableSize);
        ArrayList<HashNode<K,V>> listaAuxiliar = new ArrayList<>();
        //LLena todo el Hash de nodos nulos
        for(int i = 0; i < tableSize; i++){
            Hash_nuevo.add(null);
        }
        
        
        for (int i = 0; i < tablesizeVIEJO; i++) { 
            if(Hash.get(i)!=null){
                if(Hash.get(i).borrado==true){   
                }
                else{
                    HashNode<K,V> Nodo_Que_Tenemos_Que_Mudar=Hash.get(i);
                    listaAuxiliar.add(Nodo_Que_Tenemos_Que_Mudar);
                    
                    //El error es que si el lugar es el mismo el set los va a poner uno arriba del otro
                    //Hash_nuevo.put(lugarEnNuevoHash, Nodo_Que_Tenemos_Que_Mudar);
                }
            }
        }
        this.Hash=Hash_nuevo;
        for (int i=0; i<listaAuxiliar.size();i++){
            HashNode<K,V> nodoaux= listaAuxiliar.get(i);
            this.put(nodoaux.key,nodoaux.valor);
        }
        
    }
    //Listo
    private int HashFunction(K key){
        int hashValue = key.hashCode();
        if (hashValue < 0) {
            hashValue = -hashValue;
            if (hashValue < 0) {
                hashValue = 0;
            }
        }
        return hashValue % tableSize;
    }
    //Listo

    public String ShowHash(){
        String resultado="{";
        for(int i=0;i<tableSize;i++){
            if (this.Hash.get(i)==null || this.Hash.get(i).borrado==true){
                resultado = resultado+ "NULL, ";
            }
            else{
            resultado= resultado + this.Hash.get(i).valor+", ";
        }
    }
        resultado= resultado +"\b" +"\b" +"}";
        return resultado;
    }

    public V get(K key) {
        int index = HashFunction(key);

        while (Hash.get(index) != null) {
            if (Hash.get(index).key.equals(key) && !Hash.get(index).borrado) {
                return Hash.get(index).valor;
            }
            index = (index + 1) % tableSize;
        }

        return null;
    }

    public int size() {
        return capacity;
    }

    public MyList<K> getKeys() {
        MyList<K> keys = new MyLinkedListImpl<>();
        for (int i = 0; i < tableSize; i++) {
            HashNode<K, V> node = Hash.get(i);
            if (node != null && !node.borrado) {
                keys.add(node.key);
            }
        }
        return keys;
    }


   
}