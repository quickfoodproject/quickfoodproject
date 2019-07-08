import { Foto } from './foto';
import { Usuario } from './usuario';
import { Ingrediente } from './ingrediente';
import { Avaliacao } from './avaliacao';

export class Receita {
    bdID: number;
    bdNome: string;
    bdDescricao: string;
    bdURLlmagem: string;
    bdFkFoto: Foto;
    bdCurtidas: number;
    bdDKUsuario: Usuario;
    tbingredienteCollection: Ingrediente[];
    tbavaliacaoCollection: Avaliacao[];
}
