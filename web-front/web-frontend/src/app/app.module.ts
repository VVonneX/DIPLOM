import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {MinimalisticUiKitForAngularModule} from "../../projects/minimalistic-ui-kit-for-angular/src/lib/minimalistic-ui-kit-for-angular.module";
import { MainPageComponent } from './pages/main-page/main-page.component';
import { LoginPageComponent } from './pages/login-page/login-page.component';
import {FormsModule} from "@angular/forms";
import {HttpClientModule,  HttpClient} from "@angular/common/http";
import { FeedComponent } from './pages/feed/feed.component';
import { CreateEditComponent } from './pages/feed/create-edit/create-edit.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { MatFormFieldModule } from '@angular/material/form-field';
import {MatInputModule} from '@angular/material/input';
import { EditorModule } from '@tinymce/tinymce-angular';
import {MatButtonModule} from '@angular/material/button';

@NgModule({
  declarations: [
    AppComponent,
    MainPageComponent,
    LoginPageComponent,
    FeedComponent,
    CreateEditComponent,
  ],
  imports: [
    MatInputModule,
    EditorModule,
    MatButtonModule,
    BrowserModule,
    MatDialogModule,
    MatFormFieldModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    MinimalisticUiKitForAngularModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [HttpClient],
  bootstrap: [AppComponent]
})
export class AppModule { }
