import {Component, OnInit, ViewChild} from '@angular/core';
import {PartenaireService} from "../../services/partenaire.service";
import {MatPaginator, PageEvent} from "@angular/material/paginator";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-list-partenaire',
  templateUrl: './list-partenaire.component.html',
  styleUrls: ['./list-partenaire.component.css']
})
export class ListPartenaireComponent implements OnInit {

  partners: any[] = [];
  displayedColumns: string[] = ['alias', 'type', 'direction', 'processedFlowType', 'description', 'actions'];
  totalPartners: number = 0;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  dataSource: MatTableDataSource<any> = new MatTableDataSource();

  constructor(private partnerService: PartenaireService) { }

  ngOnInit(): void {
    this.getPartners(0, 5);
  }

  getPartners(page: number, size: number): void {
    this.partnerService.getPartenaires(page,size).subscribe(
      (data: any) => {
        this.partners = data.content;
        this.totalPartners = data.totalElements;
        this.dataSource.data = this.partners;
        this.dataSource.paginator = this.paginator;
      },
      error => {
        console.error('Error fetching partners', error);
      }
    );
  }

  onPageChange(event: PageEvent): void {
    const page = event.pageIndex;
    const size = event.pageSize;
    this.getPartners(page, size);  // Fetch data for the selected page
  }
  onDeletePartner(id: number): void {
    this.partnerService.deletePartenaire(id).subscribe(() => {
      this.getPartners(0,5);  // Refresh the list after deleting
    });
  }

}
