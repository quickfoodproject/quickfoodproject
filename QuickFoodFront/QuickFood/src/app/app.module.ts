import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioLoginComponent } from './control/usuario/login/usuario-login/usuario-login.component';
import { UsuarioService } from './usuario.service';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [UsuarioService],
  bootstrap: [AppComponent]
})
export class AppModule { }
