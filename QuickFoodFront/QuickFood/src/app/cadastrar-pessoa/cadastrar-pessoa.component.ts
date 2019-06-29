import { Component, OnInit } from '@angular/core';
import { Pessoa } from '../model/pessoa';
import { CadastroPessoaService } from './cadastro-pessoa.service';
import { FormBuilder, Validators, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-cadastrar-pessoa',
  templateUrl: './cadastrar-pessoa.component.html',
  styleUrls: ['./cadastrar-pessoa.component.css']
})
export class CadastrarPessoaComponent implements OnInit {

  pessoa: Pessoa;
  pessoaForm: FormGroup;

  constructor(private cadPessoaService: CadastroPessoaService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.pessoaForm = this.formBuilder.group({
      bdID: [-1],   
      bdNome: ['', [Validators]],
      bdSexo: ['', [Validators]] 
      // bdDataNascimento: Date;   
    })
  }

  cadastrarPessoa() {
    return this.cadPessoaService.cadastrarPessoa(this.pessoa);
  }

  onSubmit() {
    this.pessoa = this.pessoaForm.value;
    this.cadastrarPessoa()
      .subscribe(dados => this.pessoa = dados);
  }

}
