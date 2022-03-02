package hdl
package dvi_tx

import chisel3._
import sv2chisel.helpers.vecconvert._
//
//Written by GowinSynthesis
//Product Version "GowinSynthesis V1.9.8.03"
//Mon Feb 14 00:27:29 2022

//Source file index table:
//file0 "\D:/Gowin/Gowin_V1.9.8.03/IDE/ipcore/DVI_TX/data/dvi_tx_top.v"
//file1 "\D:/Gowin/Gowin_V1.9.8.03/IDE/ipcore/DVI_TX/data/rgb2dvi.vp"
// `timescale100ps/100ps


class DVI_TX_Top() extends RawModule {
  val I_rst_n = IO(Input(Bool()))
  val I_serial_clk = IO(Input(Bool()))
  val I_rgb_clk = IO(Input(Bool()))
  val I_rgb_vs = IO(Input(Bool()))
  val I_rgb_hs = IO(Input(Bool()))
  val I_rgb_de = IO(Input(Bool()))
  val I_rgb_r = IO(Input(Vec(8, Bool())))
  val I_rgb_g = IO(Input(Vec(8, Bool())))
  val I_rgb_b = IO(Input(Vec(8, Bool())))
  val O_tmds_clk_p = IO(Output(Bool()))
  val O_tmds_clk_n = IO(Output(Bool()))
  val O_tmds_data_p = IO(Output(Vec(3, Bool())))
  val O_tmds_data_n = IO(Output(Vec(3, Bool())))
  val VCC = Wire(Bool()) 
  val GND = Wire(Bool()) 
  val rgb2dvi_inst = Module(new \~rgb2dvi.DVI_TX_Top  )
  rgb2dvi_inst.I_rgb_clk := I_rgb_clk
  rgb2dvi_inst.I_serial_clk := I_serial_clk
  rgb2dvi_inst.I_rst_n := I_rst_n
  rgb2dvi_inst.I_rgb_de := I_rgb_de
  rgb2dvi_inst.I_rgb_vs := I_rgb_vs
  rgb2dvi_inst.I_rgb_hs := I_rgb_hs
  rgb2dvi_inst.I_rgb_r := I_rgb_r(7,0)
  rgb2dvi_inst.I_rgb_g := I_rgb_g(7,0)
  rgb2dvi_inst.I_rgb_b := I_rgb_b(7,0)
  O_tmds_clk_p := rgb2dvi_inst.O_tmds_clk_p.asTypeOf(O_tmds_clk_p)
  O_tmds_clk_n := rgb2dvi_inst.O_tmds_clk_n.asTypeOf(O_tmds_clk_n)
  O_tmds_data_p(2,0) := rgb2dvi_inst.O_tmds_data_p.asTypeOf(O_tmds_data_p(2,0))
  O_tmds_data_n(2,0) := rgb2dvi_inst.O_tmds_data_n.asTypeOf(O_tmds_data_n(2,0))
  val VCC_cZ = Module(new VCC)
  VCC_cZ.V <> VCC
  val GND_cZ = Module(new GND)
  GND_cZ.G <> GND
  val GSR = Module(new GSR)
  GSR.GSRI <> VCC
} /* DVI_TX_Top */