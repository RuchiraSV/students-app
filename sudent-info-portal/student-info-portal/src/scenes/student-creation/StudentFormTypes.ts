interface StudentFormValues {
    studentName: string;
    studentAge: number;
    address: string;
}

interface StudentFormResponse {
    success: boolean;
    message: string;
    data?: StudentFormValues;
}

export type { StudentFormValues, StudentFormResponse };
