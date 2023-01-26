/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package her__b;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Asus
 */
public class HutangDaoImpl implements HutangDao {

    private List<Hutang> data = new ArrayList<>();

    public HutangDaoImpl() {
    }

    public Hutang save(Hutang hutang) {
       data.add(hutang);
       return hutang;
    }

    public Hutang update(int index, Hutang hutang) {
        data.set(index, hutang);
        return hutang;
    }

    public void delete(int index) {
        data.remove(index);
    }

    public Hutang getHutang(int index) {
        return data.get(index);
    }

    public List<Hutang> getAllHutang() {
        return data;
    }
    
    
    
}
