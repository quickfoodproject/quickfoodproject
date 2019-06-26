import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Usuario } from '../model/usuario';
import { Config } from '../config/config';

@Injectable({
  providedIn: 'root'
})
export class LogarService {

  constructor(private http: HttpClient) { }

  logar(usuario: Usuario) {
     let options = {
       headers: Config.getHttpHeders(),
     };

    return this.http.post<Usuario>(`${Config.logarUrl}`, usuario, options);
  }
}
