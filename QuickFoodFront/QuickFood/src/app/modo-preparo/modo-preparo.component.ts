import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Receita } from '../model/receita';
import { Router } from '@angular/router';
import { Ingrediente } from '../model/ingrediente';
import { ModoPreparo } from '../model/modo-preparo';

@Component({
  selector: 'app-modo-preparo',
  templateUrl: './modo-preparo.component.html',
  styleUrls: ['./modo-preparo.component.css']
})
export class ModoPreparoComponent implements OnInit {

  modoPreparoForm: FormGroup;
  receita: Receita;
  ingredientes: Ingrediente[];
  modoPreparo: ModoPreparo;

  constructor(private formBuilder: FormBuilder, private router: Router) { }

  ngOnInit() {
    this.modoPreparoForm = this.formBuilder.group({
      modoPreparo: ['', Validators.required]
    });

    const jsonReceita = window.sessionStorage.getItem('receita');

    this.receita = JSON.parse(jsonReceita);
    this.ingredientes = this.receita.tbingredienteCollection;
  }

  proximaPagina() {
    this.salvarReceitaLocal();

    this.router.navigate(['\concluir']);
  }

  salvarReceitaLocal() {
    this.modoPreparo = this.modoPreparoForm.value;
    this.receita.bdDescricao = this.modoPreparo.bdDescricao;

    const jsonAux = JSON.stringify(this.receita);

    window.sessionStorage.setItem('receita', jsonAux);
  }



}
