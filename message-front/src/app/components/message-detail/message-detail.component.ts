import {Component, Inject} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material/dialog';
import {Message} from "../../models/Message";
@Component({
  selector: 'app-message-detail',
  templateUrl: './message-detail.component.html',
  styleUrls: ['./message-detail.component.css']
})
export class MessageDetailComponent {
  constructor(public dialogRef: MatDialogRef<MessageDetailComponent>,
              @Inject(MAT_DIALOG_DATA) public data: { message: Message }) {}

}
