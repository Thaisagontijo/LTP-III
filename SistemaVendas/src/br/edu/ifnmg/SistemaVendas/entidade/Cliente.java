/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.SistemaVendas.entidade;

public class Cliente extends Pessoa {
    private int idCliente;

    public Cliente(){
        this.idCliente = 0;
    }
    public Cliente(int id) {
        this.idCliente = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) throws ErroValidacaoException  {
        if(idCliente < 0 )
               throw new ErroValidacaoException("O id não pode ser menor que 0 !");
        else
            this.idCliente = idCliente;this.idCliente = idCliente;
    }



    
        

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idCliente;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.idCliente != other.idCliente) {
            return false;
        }
        return true;
    }
    
   

    
}
