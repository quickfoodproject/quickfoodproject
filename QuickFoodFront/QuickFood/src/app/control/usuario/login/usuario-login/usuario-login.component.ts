import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/usuario.service';

@Component({
  selector: 'app-usuario-login',
  templateUrl: './usuario-login.component.html',
  styleUrls: ['./usuario-login.component.css']
})
export class UsuarioLoginComponent implements OnInit {

  constructor(userService: UsuarioService) { }

  ngOnInit() {
  }

  logar() {
    
  }

}
