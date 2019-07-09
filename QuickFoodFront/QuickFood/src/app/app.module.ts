import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioLoginComponent } from './control/usuario/login/usuario-login/usuario-login.component';
import { UsuarioService } from './usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PaginaInicialComponent } from './pagina-inicial/pagina-inicial.component';
import { Routes, RouterModule } from '@angular/router';
import { CadastrarReceitaComponent } from './cadastrar-receita/cadastrar-receita.component';
import { Usuario } from './model/usuario';
import { Receita } from './model/receita';
import { CadastrarIngredienteComponent } from './cadastrar-ingrediente/cadastrar-ingrediente.component';
import { CadastrarUnidadeMedidaComponent } from './cadastrar-unidade-medida/cadastrar-unidade-medida.component';
import { ModoPreparoComponent } from './modo-preparo/modo-preparo.component';
import { VisualizarReceitaComponent } from './visualizar-receita/visualizar-receita.component';
import { ConcluirReceitaComponent } from './concluir-receita/concluir-receita.component';

const appRoutes: Routes = [
  { path: 'login', component: UsuarioLoginComponent },
  { path: 'cadastar-receita', component: CadastrarReceitaComponent },
  { path: 'cadastrar-ingrediente', component: CadastrarIngredienteComponent },
  { path: 'cadastrar-unidade-medida', component: CadastrarUnidadeMedidaComponent },
  { path: 'modo-preparo', component: ModoPreparoComponent },
  { path: 'receita', component: VisualizarReceitaComponent},
  { path: 'concluir', component: ConcluirReceitaComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    UsuarioLoginComponent,
    PaginaInicialComponent,
    CadastrarReceitaComponent,
    CadastrarIngredienteComponent,
    CadastrarUnidadeMedidaComponent,
    ModoPreparoComponent,
    VisualizarReceitaComponent,
    ConcluirReceitaComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes, {enableTracing: true}),
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
