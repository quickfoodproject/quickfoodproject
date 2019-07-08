import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioLoginComponent } from './control/usuario/login/usuario-login/usuario-login.component';
import { UsuarioService } from './usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PaginaInicialComponent } from './pagina-inicial/pagina-inicial.component';
import { Routes } from '@angular/router';
import { CadastrarReceitaComponent } from './cadastrar-receita/cadastrar-receita.component';
import { Usuario } from './model/usuario';
import { CadastrarIngredienteComponent } from './model/cadastrar-ingrediente/cadastrar-ingrediente.component';
import { CadastrarUnidadeMedidaComponent } from './model/cadastrar-unidade-medida/cadastrar-unidade-medida.component';

const appRoutes: Routes = [
  { path: 'login', component: UsuarioLoginComponent},
  { path: 'cadastar-receita', component: CadastrarReceitaComponent, data: {usuario: Usuario}}
]
  

@NgModule({
  declarations: [
    AppComponent,
    UsuarioLoginComponent,
    PaginaInicialComponent,
    CadastrarReceitaComponent,
    CadastrarIngredienteComponent,
    CadastrarUnidadeMedidaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule 
  ],
  providers: [UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
