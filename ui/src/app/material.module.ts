import {NgModule} from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {MatInputModule} from '@angular/material/input';
import {FlexLayoutModule} from '@angular/flex-layout';
import {MatIconModule} from '@angular/material/icon';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import {MatCardModule} from '@angular/material/card';
import {MatListModule} from '@angular/material/list';
import {MatTableModule} from '@angular/material/table';


@NgModule({
  declarations: [],
  imports: [
    MatButtonModule, MatToolbarModule, MatInputModule, FlexLayoutModule, MatIconModule, MatProgressSpinnerModule, MatCardModule,
    MatListModule, MatTableModule
  ],
  exports: [
    MatButtonModule, MatToolbarModule, MatInputModule, FlexLayoutModule, MatIconModule, MatProgressSpinnerModule, MatCardModule,
    MatListModule, MatTableModule
  ]
})
export class MaterialModule {
}
