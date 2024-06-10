export interface AttendanceRequestModel {
	id: number;
	userId: number;
	recipientId: number;
	eventId: number;
	status: string;
}