import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioLoginComponent } from './control/usuario/login/usuario-login/usuario-login.component';
import { UsuarioService } from './usuario.service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { Routes } from '@angular/router';
import { PaginainicialComponent } from './paginainicial/paginainicial.component';

const appRoutes: Routes = [
  { path: 'login', component: UsuarioLoginComponent},
  { path: 'pagina-inicial', component: PaginainicialComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    UsuarioLoginComponent,
    PaginainicialComponent
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
