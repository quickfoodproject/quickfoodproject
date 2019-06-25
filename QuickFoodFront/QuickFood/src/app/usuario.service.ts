import { Injectable } from '@angular/core';
import { Usuario } from './model/usuario';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  urlLogar = "http://localhost:8080/WebServiceQuickFood/webresources/quickfood/Usuario/logar/";

  constructor(private http: HttpClient) { }

  logar(user: Usuario) {
    return this.http.post<Usuario>(this.urlLogar, user);
  }
}
