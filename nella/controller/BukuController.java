/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nella.controller;

import nella.view.*;
import nella.model.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.List;
/**
 *
 * @author Asus
 */
public class BukuController {
    private FormBuku formbuku;
    private BukuDao bukudao;
    private Buku buku;

    public BukuController(FormBuku formbuku) {
        this.formbuku = formbuku;
        bukudao = new BukuDaoImpl();
    }
    
    public void bersihForm(){
        formbuku.getTxtKode().setText("");
        formbuku.getTxtJudul().setText("");
        formbuku.getTxtPengarang().setText("");
        formbuku.getTxtPenerbit().setText("");
    }
    public void save(){
        buku = new Buku();
        buku.setKodebuku(formbuku.getTxtKode().getText());
        buku.setJudul(formbuku.getTxtJudul().getText());
        buku.setPengarang(formbuku.getTxtPengarang().getText());
        buku.setPenerbit(formbuku.getTxtPenerbit().getText());
        bukudao.save(buku);
        JOptionPane.showMessageDialog(formbuku,"Insert OK");
    }
    public void updateBuku(){
        int index = formbuku.getTblBuku().getSelectedRow();
        buku = bukudao.getBuku(index);
        buku.setKodebuku(formbuku.getTxtKode().getText());
        buku.setJudul(formbuku.getTxtJudul().getText());
        buku.setPengarang(formbuku.getTxtPengarang().getText());
        buku.setPenerbit(formbuku.getTxtPenerbit().getText());
        bukudao.update(index,buku);
        JOptionPane.showMessageDialog(formbuku,"Update OK");
    }
    public void deleteBuku(){
        int index = formbuku.getTblBuku().getSelectedRow();
        bukudao.delete(index);
        javax.swing.JOptionPane.showMessageDialog(formbuku,"Delete Ok");
    }
    public void tampil(){
        DefaultTableModel tabelModel = ( DefaultTableModel) formbuku.getTblBuku().
        getModel();
        tabelModel.setRowCount(0);
        java.util.List <Buku> listBuku = bukudao.getAllBuku();
        for(Buku buku : listBuku){
            Object[] data = {
                buku.getKodebuku(),
                buku.getJudul(),
                buku.getPengarang(),
                buku.getPenerbit(),
            };
        tabelModel.addRow(data);
        }
    }
    public void getBuku(){
        int index = formbuku.getTblBuku().getSelectedRow();
        buku = bukudao.getBuku(index);
        if (buku != null){
            formbuku.getTxtKode().setText(buku.getKodebuku());
            formbuku.getTxtJudul().setText(buku.getJudul());
            formbuku.getTxtPengarang().setText(buku.getPengarang());
            formbuku.getTxtPenerbit().setText(buku.getPenerbit());
        }
    }
}
