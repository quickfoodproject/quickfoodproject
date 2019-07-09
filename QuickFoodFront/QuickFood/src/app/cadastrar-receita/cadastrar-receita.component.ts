import { Component, OnInit } from '@angular/core';
import { Receita } from '../model/receita';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from '../model/usuario';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-cadastrar-receita',
  templateUrl: './cadastrar-receita.component.html',
  styleUrls: ['./cadastrar-receita.component.css']
})
export class CadastrarReceitaComponent implements OnInit {

  receita: Receita;
  usuario: Usuario;
  receitaForm: FormGroup;

  constructor(private router: Router, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.receitaForm = this.formBuilder.group({
      bdId: [-1],
      bdNome: ['', Validators.required],
      bdDescricao: ['', Validators.required],
      bdURLlmagem: ['', Validators.required],
      bdFkFoto: [null],
      bdCurtidas: [-1],
      bdDKUsuario: [null],
      tbingredienteCollection: [null],
      tbavaliacaoCollection: [null]
    });

    //this.usuario.bdId = window.sessionStorage.getItem('usuario');
  }

  proximaPagina() {
    this.salvarReceitaLocal();

    this.router.navigate(['\cadastrar-ingrediente']);
  }

  salvarReceitaLocal() {
    this.receita = this.receitaForm.value;

    const jsonAux = JSON.stringify(this.receita);

    // "Seta" este json no localStorage
    window.sessionStorage.setItem('receita', jsonAux);
  }
}
