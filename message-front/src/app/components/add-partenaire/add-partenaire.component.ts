import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {PartenaireService} from "../../services/partenaire.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-add-partenaire',
  templateUrl: './add-partenaire.component.html',
  styleUrls: ['./add-partenaire.component.css']
})
export class AddPartenaireComponent implements OnInit {
  partnerForm!: FormGroup;
  partnerTypes = ['Permanent', 'Associe', 'Autre'];
  directions = ['INBOUND', 'OUTBOUND'];
  processedFlowTypes = ['MESSAGE', 'ALERTING', 'NOTIFICATION'];

  constructor(
    private fb: FormBuilder,
    private router: Router,
    private partnerService: PartenaireService
  ) { }

  ngOnInit(): void {
    this.partnerForm = this.fb.group({
      alias: ['', Validators.required],
      type: ['', Validators.required],
      direction: ['', Validators.required],
      application: [''],
      processedFlowType: ['', Validators.required],
      description: ['', Validators.required]
    });
  }
  onSubmit(): void {
    if (this.partnerForm?.valid) {
      this.partnerService.addPartenaire(this.partnerForm.value).subscribe(
        response => {
          console.log('Partner added successfully', response);
          this.partnerForm?.reset();
          this.router.navigateByUrl('/partners')
        },
        error => {
          console.error('Error adding partner', error);
        }
      );
    } else {
      console.log('Form is invalid');
    }
  }
}
