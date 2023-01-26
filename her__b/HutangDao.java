/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package her__b;

import java.util.List;

/**
 *
 * @author Asus
 */
public interface HutangDao {
    Hutang save(Hutang hutang);
    Hutang update(int index, Hutang hutang);
    void delete(int index);
    Hutang getHutang(int index);
    List<Hutang> getAllHutang();

}
