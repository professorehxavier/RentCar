
package br.com.senac.rentcar.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import javax.swing.JOptionPane;
import br.com.senac.rentcar.model.Cliente;
import br.com.senac.rentcar.model.Veiculo;
import br.com.senac.rentcar.model.Locacao;

/**
 *
 * @author sala305b
 */
public class LocacaoDAO {
    
    private Connection conexao;
    
    public LocacaoDAO() {
        conexao = ConnectionFactory.getConnection();
    }
    
    public boolean inserirLocacao(Locacao locacao) {
        
        boolean resultado = false;
        
        String sql = "insert into locacoes (data_locacao, data_devolucao, observacao, valor_locacao, cpf_cliente, chassi_veiculo) "
                + "values (?,?,?,?,?,?)";
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            Date dataLoc = new Date(locacao.getDataLocacao().getTimeInMillis());
            stmt.setDate(1, dataLoc);
            Date dataDev = new Date(locacao.getDataDevolucao().getTimeInMillis());
            stmt.setDate(2, dataDev);
            stmt.setString(3, locacao.getObservacao());
            stmt.setDouble(4, locacao.getValorlocacao());
            stmt.setString(5, locacao.getCliente().getCpf());
            stmt.setString(6, locacao.getVeiculo().getChassi());

            stmt.executeUpdate();
            stmt.close();
            
            resultado = true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao salvar locação - " + ex.getMessage());
        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao fechar conexão - " + ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        return resultado;
    }

    //buscando dados da tabela para exibir no formulário
    public ArrayList<Locacao> getlist() {
        
        ArrayList<Locacao> arrayLocacoes = new ArrayList<>();
        String sql = "select cl.*, lc.*, ve.* " +
                     "from clientes cl, locacoes lc, veiculos ve " +
                     "where lc.cpf_cliente = cl.cpf " +
                     "and lc.chassi_veiculo = ve.chassi ";
        
        
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            //quando abre o rs, ele não vai pro primeiro registro. é necessário usar o rs.next() para que ele vá para o primeiro e, depois, para os próximos
            while (rs.next()) {

                Cliente cliente = new Cliente();
                cliente.setCpf(rs.getString("cl.cpf"));
                cliente.setNome(rs.getString("cl.nome"));
                cliente.setEndereco(rs.getString("cl.endereco"));
                cliente.setSexo(rs.getString("cl.sexo"));
                cliente.setTelefone(rs.getString("cl.telefone"));
                cliente.setCelular(rs.getString("cl.celular"));

                Veiculo veiculo = new Veiculo();
                veiculo.setChassi(rs.getString("ve.chassi"));
                veiculo.setPlaca(rs.getString("ve.placa"));
                veiculo.setMarca(rs.getString("ve.marca"));
                veiculo.setModelo(rs.getString("ve.modelo"));
                veiculo.setAnoFabricacao(Integer.parseInt(rs.getString("ve.ano_fabricacao")));
                veiculo.setValorLocacao(Double.parseDouble(rs.getString("ve.valor_locacao")));
                veiculo.setStatus(rs.getString("ve.situacao"));

                Locacao locacao = new Locacao();
                locacao.setCliente(cliente);
                locacao.setVeiculo(veiculo);
                locacao.setObservacao(rs.getString("lc.observacao"));
                locacao.setValorlocacao(Double.parseDouble(rs.getString("lc.valor_locacao")));
                
                
                try{
                    Calendar dataLoc = Calendar.getInstance();
                    dataLoc.setTime(rs.getDate("lc.data_locacao"));
                    locacao.setDataLocacao(dataLoc);

                    Calendar dataDev = Calendar.getInstance();
                    dataDev.setTime(rs.getDate("lc.data_devolucao"));
                    locacao.setDataDevolucao(dataDev);
                    
                }catch(Exception ex){
                    
                }
                
                arrayLocacoes.add(locacao);
            }
            stmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro no acesso ao banco de dados - " + ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
        } finally {

            try {
                conexao.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Erro ao fechar conexão - " + ex.getMessage(), "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        }
        
        return arrayLocacoes;
                
    }
    
    
}
