import { Injectable } from '@angular/core';
import { Usuario } from './model/usuario';
import { HttpClient } from 'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  urlLogar = "";

  constructor(private http: HttpClient) { }

  logar(user: Usuario) {
    //
  }
}
