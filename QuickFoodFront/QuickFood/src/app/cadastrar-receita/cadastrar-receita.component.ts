import { Component, OnInit } from '@angular/core';
import { Receita } from '../model/receita';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from '../model/usuario';

@Component({
  selector: 'app-cadastrar-receita',
  templateUrl: './cadastrar-receita.component.html',
  styleUrls: ['./cadastrar-receita.component.css']
})
export class CadastrarReceitaComponent implements OnInit {

  receita: Receita;
  usuario: Usuario;

  constructor(private router: Router) { }

  ngOnInit() {
    this.usuario.bdId = window.sessionStorage.getItem('usuario');

  }

  proximaPagina() {
    this.salvarReceitaLocal();

    this.router.navigate(['cadastrar-ingrediente']);
  }

  salvarReceitaLocal() {
    const jsonAux = JSON.stringify(this.receita);

    // "Seta" este json no localStorage
    window.sessionStorage.setItem('receita', jsonAux);
  }
}
