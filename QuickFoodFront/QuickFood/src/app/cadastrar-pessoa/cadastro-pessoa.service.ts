import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pessoa } from '../model/pessoa';

@Injectable({
  providedIn: 'root'
})
export class CadastroPessoaService {

  urlCadastroPessoa = "http://localhost:8080";

  constructor(private http: HttpClient) { }

  cadastrarPessoa(pessoa: Pessoa) {
    return this.http.post<Pessoa>(`${this.urlCadastroPessoa}`, pessoa);      
  } 
}
