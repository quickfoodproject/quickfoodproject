import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/usuario.service';
import { Usuario } from 'src/app/model/usuario';
import { FormBuilder, Validators} from '@angular/forms'
@Component({
  selector: 'app-usuario-login',
  templateUrl: './usuario-login.component.html',
  styleUrls: ['./usuario-login.component.css']
})
export class UsuarioLoginComponent implements OnInit {

  usuario: Usuario;
  usuarioForm: any;

  constructor(private userService: UsuarioService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.usuarioForm = this.formBuilder.group({
      login: ['', Validators.required],
      senha: ['', Validators.required],
      email: ['', Validators.required]
    })
  }

  logar() {
    return this.userService.logar(this.usuario);
  }

  onSubmit() {
    this.usuario = this.usuarioForm.value;
    this.logar().subscribe(dados => this.usuario = dados);
  }

}
