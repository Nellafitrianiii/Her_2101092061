/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package her__b;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import uas_a.model.Taksi;

/**
 *
 * @author Asus
 */
public class HutangController {
    private FormHutang formhutang;
    private Hutang hutang;
    private HutangDao hutangdao;

    public HutangController(FormHutang formhutang) {
        this.formhutang = formhutang;
        hutangdao = (HutangDao) new HutangDaoImpl();
    }

    public void bersihForm (){
        formhutang.getTxtKode().setText("");
        formhutang.getTxtTgl().setText("");
        formhutang.getTxtBeli().setText("");
        formhutang.getTxtTotalb().setText("");
    }
    public void saveHutang(){
        hutang = new Hutang();
        hutang.setKode(formhutang.getTxtKode().getText());
        hutang.setTgl(formhutang.getTxtTgl().getText());
        hutang.setPembeli(formhutang.getTxtBeli().getText());
        hutang.setTotalbeli (Integer.parseInt(formhutang.getTxtTotalb().getText()));
        hutangdao.save(hutang);
        JOptionPane.showMessageDialog(formhutang,"Insert OK");

    }
     public void updateHutang(){
        int index = formhutang.getTblHutang().getSelectedRow();
        hutang = hutangdao.getHutang(index);
        hutang.setKode(formhutang.getTxtKode().getText());
        hutang.setTgl(formhutang.getTxtTgl().getText());
        hutang.setPembeli(formhutang.getTxtBeli().getText());
        hutang.setTotalbeli (Integer.parseInt(formhutang.getTxtTotalb().getText()));
        hutangdao.save(hutang);
        JOptionPane.showMessageDialog(formhutang,"Update OK");
     }
      public void deleteHutang(){
        int index = formhutang.getTblHutang().getSelectedRow();
        hutangdao.delete(index);
        JOptionPane.showMessageDialog(formhutang, "Delete Ok");
      }
    public void tampil() {
        DefaultTableModel tabelModel = (DefaultTableModel) formhutang.getTblHutang().getModel();
        tabelModel.setRowCount(0);
        List<Hutang> list = hutangdao.getAllHutang();
        for ( Hutang hutang : list){
            Object[] row={
                hutang.getKode(),
                hutang.getTgl(),
                hutang.getPembeli(),
                hutang.getTotalbeli()
            };
            tabelModel.addRow(row);
        }
    }
    public void getHutang(){
        int index = formhutang.getTblHutang().getSelectedRow();
        hutang = hutangdao.getHutang(index);
        if(hutang!=null){
            formhutang.getTxtKode().setText(hutang.getKode());
            formhutang.getTxtTgl().setText(hutang.getTgl());
            formhutang.getTxtBeli().setText(hutang.getPembeli());
            formhutang.getTxtTotalb().setText(String.valueOf(hutang.getTotalbeli()));
        }
    }

}
