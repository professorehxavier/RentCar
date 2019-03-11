/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.senac.rentcar.model;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import br.com.senac.rentcar.model.Locacao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author sala305b
 */
public class LocacaoTableModel extends AbstractTableModel {    

    private ArrayList<Locacao> arrayLocacoes;
    
    public LocacaoTableModel(ArrayList<Locacao> arrayLocacoes) {
        this.arrayLocacoes = arrayLocacoes;
    }

    @Override
    public int getRowCount() {
        return arrayLocacoes.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Locacao locacao = arrayLocacoes.get(rowIndex);
        switch (columnIndex) {
            case 0: return locacao.getCliente().getCpf();
            case 1: return locacao.getCliente().getNome();
            case 2: return locacao.getVeiculo().getPlaca();
            case 3: return locacao.getVeiculo().getMarca() + "-" + locacao.getVeiculo().getModelo();
            case 4:  
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        return sdf.format(locacao.getDataLocacao().getTime());
                    } catch (Exception ex) {
                        return null;
                    }
            case 5: 
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        return sdf.format(locacao.getDataDevolucao().getTime());
                    } catch (Exception ex) {
                        return null;
                    }
            
            
            case 6: return formataValor(locacao.getValorlocacao());
            default: return "";
        }
        
    }   
 
    private String formataValor(Double valor){
        //PARA MOEDAS
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        return nf.format(valor);
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column){
            case 0: return "CPF";
            case 1: return "Cliente";
            case 2: return "Placa";
            case 3: return "Veiculo";
            case 4: return "Dt Loc.";
            case 5: return "Dt Devol.";
            case 6: return "Valor";
            default: return "";
        }
    }

    public Locacao getLocacao(int i){
        return this.arrayLocacoes.get(i);
    }
    
    public void atualizaTabela(){
        fireTableDataChanged();
    }
    
}
