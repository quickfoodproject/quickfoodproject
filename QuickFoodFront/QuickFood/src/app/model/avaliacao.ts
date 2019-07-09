import { Receita } from './receita';
import { Usuario } from './usuario';

export class Avaliacao {
    bdID: number;
    bdJaCurtiu: boolean;
    bdFKReceita: Receita;
    bdFKUsuario: Usuario;
    bdDescricao: string;
}
