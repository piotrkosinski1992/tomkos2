import {NgModule} from '@angular/core';
import {MatButtonModule} from "@angular/material/button";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatInputModule} from "@angular/material/input";
import {FlexLayoutModule} from '@angular/flex-layout';
import {MatIconModule} from "@angular/material/icon";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatCardModule} from "@angular/material/card";


@NgModule({
  declarations: [],
  imports: [
    MatButtonModule, MatToolbarModule, MatInputModule, FlexLayoutModule, MatIconModule, MatProgressSpinnerModule, MatCardModule
  ],
  exports: [
    MatButtonModule, MatToolbarModule, MatInputModule, FlexLayoutModule, MatIconModule, MatProgressSpinnerModule, MatCardModule
  ]
})
export class MaterialModule {
}
