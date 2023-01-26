/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nella.model;

import java.util.ArrayList;
import java.util.List;
import nella.model.Buku;

/**
 *
 * @author Asus
 */
public class BukuDaoImpl implements BukuDao {
    
    List<Buku> data = new ArrayList<>();

    public BukuDaoImpl() {
        data.add(new Buku("1111","Habis Gelap Terbitlah Terang","Kartini","Gramedia"));
        data.add(new Buku("1112","Bumi","Tere Liye","Gramedia"));
        data.add(new Buku("1113","Tuhan Aku Hampir Menyerah","Budi","Gramedia"));
    }

    public Buku save(Buku buku){
        data.add(buku);
        return buku;
    }
    
    public Buku update (int index, Buku buku){
        data.set(index,buku);
        return buku;
    }
    
    public Buku delete (int index){
        return data.remove(index);
    }
    
    public Buku getBuku(int index){
        return data.get(index);
    }
    
    public List<Buku> getAllBuku(){
        return data;
    }

    
}
